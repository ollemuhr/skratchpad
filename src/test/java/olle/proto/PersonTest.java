package olle.proto;

import com.google.protobuf.ByteString;
import olle.person.Person;
import olle.person.PersonSerializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

/**
 *
 */
@RunWith(Parameterized.class)
public class PersonTest {

    enum Funcs {
        ONE(i -> Person.OLLE.firstName().value()),
        TWO(i -> Person.OLLE.lastName().value());

        private final Function<Integer, String> f;
        Funcs(Function<Integer, String> f) {
            this.f = f;
        }
    }
    private final Person.Age a = Person.Age.of(1);

    @Parameterized.Parameters(name = "Func {1}({0})")
    public static Collection<Object[]> params() {
        Object[][] params = {{1, Funcs.ONE, "Olle"}, {2 ,Funcs.TWO, "Yuri"}};
        return Arrays.asList(params);
    }

    private final Function<Integer, String> f;
    private final Integer i;
    private final String expected;

    public PersonTest(Integer i, Funcs f, String expected) {
        this.i = i;
        this.f = f.f;
        this.expected = expected;
    }

    @Test
    public void testParams() {
        System.out.println(f.apply(i));
        assertEquals(expected, f.apply(i));
    }

    @Test
    public void testProto() {

        final PersonProto.PersonMessage proto = PersonProto.PersonMessage.newBuilder()
                .setAge(Period.between(LocalDate.of(1969, 6, 19), LocalDate.now()).getYears())
                .setFirstName("Olle")
                .setLastName("Muhr")
                .addMiddleName("Karl")
                .setEmailAddress("ollmuh@fareoffice.com")
                .setPassword(ByteString.copyFrom(new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 1})).build();

        final Person domain = Person.OLLE;

        assertEquals(domain, PersonSerializer.fromProto(proto));
        assertEquals(proto, PersonSerializer.toProto(domain));

    }

}
