package olle.person;

import olle.*;
import olle.Primitivies.ByteArrayType;
import olle.Primitivies.IntegerType;
import olle.ValidationError.ErrorCode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static java.util.Objects.requireNonNull;

/**
 *
 */
public interface Person extends ToString<Person>, EqualsHashcode<Person> {

    Person OLLE = Person.create(
            FirstName.of("Olle"),
            LastName.of("Muhr"),
            MiddleNames.of(singletonList(MiddleName.of("Karl"))),
            Optional.of(Age.of(Period.between(LocalDate.of(1969, 6, 19), LocalDate.now()).getYears())),
            Password.of(new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 1}), EmailAddress.of("ollmuh@fareoffice.com"));

    FirstName firstName();

    LastName lastName();

    MiddleNames middleNames();

    Optional<Age> age();

    EmailAddress emailAddress();

    Password password();

    default Stream<Function<Person, ?>> props() {
        return Stream.of(Person::firstName, Person::lastName, Person::middleNames, Person::age, Person::emailAddress, Person::password);
    }

    default Stream<ValidationError> validate() {
        return Stream.concat(
                props().filter(p -> p.apply(this) instanceof Optional)
                        .flatMap(p -> ((Optional<SimpleType<?>>) p.apply(this)).map(p1 -> p1.validate()).orElse(Stream.empty())),
                props().filter(p -> p.apply(this) instanceof SimpleType).flatMap(p -> ((SimpleType<?>) p.apply(this)).validate()));
    }

    static Person create(FirstName firstName, LastName lastName, MiddleNames middleNames, Optional<Age> age, Password password, EmailAddress emailAddress) {
        requireNonNull(firstName);
        requireNonNull(lastName);
        requireNonNull(age);
        requireNonNull(password);
        requireNonNull(emailAddress);
        abstract class P extends Value<Person> implements Person {
        }
        return new P() {
            @Override
            public FirstName firstName() {
                return firstName;
            }

            @Override
            public LastName lastName() {
                return lastName;
            }

            @Override
            public MiddleNames middleNames() {
                return middleNames;
            }

            @Override
            public Optional<Age> age() {
                return age;
            }

            @Override
            public EmailAddress emailAddress() {
                return emailAddress;
            }

            @Override
            public Password password() {
                return password;
            }
        };
    }

    abstract class FirstName extends Value<SimpleType<String>> implements StringType {

        public static FirstName of(String value) {
            requireNonNull(value);
            return new FirstName() {
                @Override
                public String value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return value.length() < 4 ?
                            Stream.of(new ValidationError("First name must be more than 4 chars", ErrorCode.of(1))) :
                            Stream.empty();
                }
            };
        }
    }

    abstract class LastName extends Value<SimpleType<String>> implements StringType {

        public static LastName of(String value) {
            requireNonNull(value);
            return new LastName() {
                @Override
                public String value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return value.length() < 4 ?
                            Stream.of(new ValidationError("Last name must be more than 4 chars", ErrorCode.of(2))) :
                            Stream.empty();
                }

            };
        }
    }

    abstract class MiddleName extends Value<SimpleType<String>> implements StringType {

        public static MiddleName of(String value) {
            requireNonNull(value);
            return new MiddleName() {
                @Override
                public String value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return value.length() < 4 ?
                            Stream.of(new ValidationError("Middle name must be more than 4 chars", ErrorCode.of(2))) :
                            Stream.empty();
                }
            };
        }
    }

    abstract class MiddleNames extends Value<SimpleType<List<MiddleName>>> implements SimpleType<List<MiddleName>> {

        @Override
        public Stream<ValidationError> validate() {
            return value().stream()
                    .flatMap(SimpleType::validate);
        }

        public static MiddleNames empty() {
            return new MiddleNames() {
                @Override
                public List<MiddleName> value() {
                    return new ArrayList<>();
                }
            };
        }

        public static MiddleNames of(List<MiddleName> value) {
            requireNonNull(value);
            return new MiddleNames() {
                @Override
                public List<MiddleName> value() {
                    return value;
                }
            };
        }
    }

    abstract class Age extends Value<SimpleType<Integer>> implements IntegerType {

        public static Age of(Integer value) {
            requireNonNull(value);
            return new Age() {
                @Override
                public Integer value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    System.out.println("validating");
                    return value < 5 ?
                            Stream.of(new ValidationError("Age must be more than 4", ErrorCode.of(3))) :
                            Stream.empty();
                }
            };
        }
    }

    abstract class EmailAddress extends Value<SimpleType<String>> implements StringType {
        private final static String MAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        private final static Pattern PATTERN = Pattern.compile(MAIL_REGEX);

        public static EmailAddress of(String value) {
            requireNonNull(value);
            return new EmailAddress() {
                @Override
                public String value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return PATTERN.matcher(value).matches() ?
                            Stream.empty() :
                            Stream.of(new ValidationError("Invalid mail", ErrorCode.of(7)));
                }
            };
        }
    }

    abstract class Password extends Value<SimpleType<byte[]>> implements ByteArrayType {
        final byte[] value;

        protected Password(byte[] value) {
            this.value = value;
        }

        public static Password of(byte[] value) {
            requireNonNull(value);
            return new Password(value.clone()) {
                @Override
                public byte[] value() {
                    return this.value;
                }
            };
        }
    }
}


