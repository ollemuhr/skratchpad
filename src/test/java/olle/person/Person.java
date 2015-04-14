package olle.person;

import olle.*;
import olle.Primitivies.ByteArrayType;
import olle.Primitivies.IntegerType;
import olle.ValidationError.ErrorCode;
import olle.StringType;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;

/**
 *
 */
public interface Person extends ToString<Person>, EqualsHashcode<Person> {

    Person OLLE = Person.create(
            FirstName.of("Olle"),
            LastName.of("Muhr"),
            MiddleNames.of(singletonList(MiddleName.of("Karl"))),
            Age.of(Period.between(LocalDate.of(1969, 6, 19), LocalDate.now()).getYears()),
            Password.of(new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 1}), EmailAddress.of("ollmuh@fareoffice.com"));

    FirstName firstName();

    LastName lastName();

    MiddleNames middleNames();

    Age age();

    EmailAddress emailAddress();

    Password password();

    default Stream<Function<Person, ?>> props() {
        return Stream.of(Person::firstName, Person::lastName, Person::middleNames, Person::age, Person::emailAddress, Person::password);
    }

    default Stream<ValidationError> validate() {
        return props().flatMap(p -> ((SimpleType<?>) p.apply(this)).validate());
    }

    static Person create(FirstName firstName, LastName lastName, MiddleNames middleNames, Age age, Password password, EmailAddress emailAddress) {
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
            public Age age() {
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

    interface FirstName extends StringType {
        abstract class FN extends Value implements FirstName {
        }

        static FirstName of(String value) {
            return new FN() {
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

    interface LastName extends StringType {
        abstract class LN extends Value implements LastName {
        }

        static LastName of(String value) {
            return new LN() {
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

    interface MiddleName extends StringType {
        abstract class MN extends Value implements MiddleName {
        }

        static MiddleName of(String value) {
            return new MN() {
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

    interface MiddleNames extends SimpleType<List<MiddleName>> {
        abstract class MN extends Value implements MiddleNames {
        }

        static MiddleNames of(List<MiddleName> value) {
            return new MN() {
                @Override
                public List<MiddleName> value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return value.stream()
                            .flatMap(SimpleType::validate);
                }
            };
        }
    }

    interface Age extends IntegerType {
        abstract class A extends Value implements Age {
        }

        static Age of(Integer value) {
            return new A() {
                @Override
                public Integer value() {
                    return value;
                }

                @Override
                public Stream<ValidationError> validate() {
                    return value < 5 ?
                            Stream.of(new ValidationError("Age must be more than 4", ErrorCode.of(3))) :
                            Stream.empty();
                }
            };
        }
    }

    interface EmailAddress extends StringType {
        abstract class EA extends Value implements EmailAddress {
            private final static String MAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            protected final static Pattern PATTERN = Pattern.compile(MAIL_REGEX);
        }

        static EmailAddress of(String value) {
            return new EA() {
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

    interface Password extends ByteArrayType {
        abstract class P extends Value implements Password {
            final byte[] value;

            protected P(byte[] value) {
                this.value = value;
            }
        }

        static Password of(byte[] value) {
            return new P(value.clone()) {
                @Override
                public byte[] value() {
                    return this.value;
                }
            };
        }
    }
}


