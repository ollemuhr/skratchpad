package olle;

import olle.person.Person;
import olle.person.Person.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SimpleTypesTest {

    private Person person1 = Person.create(FirstName.of("Olle"), LastName.of("Muhr"), MiddleNames.of(singletonList(MiddleName.of("Karl"))), Optional.of(Age.of(46)), Password.of(new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 1}), EmailAddress.of("o@m.se"));
    private Person person2 = Person.create(FirstName.of("Nisse"), LastName.of("Muhr"), MiddleNames.of(singletonList(MiddleName.of("Karl"))), Optional.of(Age.of(46)), Password.of(new byte[]{0x1}), EmailAddress.of("o@m.se"));
    private Person person3 = Person.create(FirstName.of("Olle"), LastName.of("Muhr"), MiddleNames.of(singletonList(MiddleName.of("Karl"))), Optional.of(Age.of(46)), Password.of(new byte[]{(byte) 0xAB, (byte) 0xCD, (byte) 0xEF, 1}), EmailAddress.of("o@m.se"));

    @Test
    public void testOf() {
        System.out.println(SimpleType.newMicroType(FirstName.class, "test"));
    }

    @Test
    public void testToString() {
        System.out.println(FirstName.of("Olle"));
        System.out.println(person1);
        System.out.println(person1.firstName());
        System.out.println(person1.age());
        System.out.println(person1.password().hexString());
    }

    @Test
    public void testEquals() {
        assertEquals(FirstName.of("Olle"), FirstName.of("Olle"));
        assertNotEquals(FirstName.of("Olle"), FirstName.of("Pelle"));
        assertNotEquals(LastName.of("Olle"), FirstName.of("Olle"));
        assertEquals(person1, person3);
        assertNotEquals(person1, person2);

    }

    @Test
    public void testHashCode() {
        assertEquals(FirstName.of("Olle").hashCode(), FirstName.of("Olle").hashCode());
        assertEquals(FirstName.of("Olle").hashCode(), LastName.of("Olle").hashCode());
        assertNotEquals(FirstName.of("Olle").hashCode(), FirstName.of("Pelle").hashCode());
        assertEquals(person1.hashCode(), person3.hashCode());
        assertNotEquals(person1, person2);
    }

    @Test
    public void testValid() {
        assertEquals(0, person1.validate().count());
        Person invalid = Person.create(FirstName.of("Oll"), LastName.of("Mur"), MiddleNames.of(singletonList(MiddleName.of("Kal"))), Optional.of(Age.of(4)), Password.of(new byte[]{2}), EmailAddress.of("om.se"));
        invalid.validate().forEach(System.out::println);
        assertEquals(5, invalid.validate().count());
        Person p = Person.create(Person.OLLE.firstName(), Person.OLLE.lastName(), Person.OLLE.middleNames(), Optional.empty(), Person.OLLE.password(), Person.OLLE.emailAddress());
        p.validate().forEach(System.out::println);
        System.out.println(p.toString());

    }

    @Test
    public void testCompare() {
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final List<Integer> sorted = Stream.of(Age.of(5), Age.of(4), Age.of(3), Age.of(2), Age.of(1), Age.of(6), Age.of(7), Age.of(8), Age.of(9)).sorted().map(SimpleType::value).collect(Collectors.toList());
        assertEquals(expected, sorted);
    }
}