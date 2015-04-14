package olle.proto;

import com.google.protobuf.ByteString;
import olle.person.Person;
import olle.person.PersonSerializer;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class PersonTest {

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
