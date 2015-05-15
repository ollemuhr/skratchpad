package olle.person;

import com.google.protobuf.ByteString;
import com.google.protobuf.ProtocolStringList;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import olle.SimpleType;
import olle.person.Person.*;
import olle.proto.PersonProto.PersonMessage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 */
public class PersonSerializer implements StreamSerializer<Person> {

    @Override
    public void write(ObjectDataOutput out, Person person) throws IOException {
        out.write(toProto(person).toByteArray());
    }

    @Override
    public Person read(ObjectDataInput in) throws IOException {
        return fromProto(PersonMessage.parseFrom((InputStream) in));
    }

    @Override
    public int getTypeId() {
        return 1;
    }

    @Override
    public void destroy() {

    }

    public static Person fromProto(PersonMessage p) {
        return Person.create(
                FirstName.of(p.getFirstName()),
                LastName.of(p.getLastName()),
                MiddleNames.of(middleNames(p.getMiddleNameList())),
                Optional.ofNullable(p.getAge()).map(Age::of),
                Password.of(p.getPassword().toByteArray()),
                EmailAddress.of(p.getEmailAddress()));
    }

    public static PersonMessage toProto(Person p) {
        return PersonMessage.newBuilder()
                .setFirstName(p.firstName().value())
                .setLastName(p.lastName().value())
                .addAllMiddleName(middleNames(p.middleNames().value()))
                .setAge(p.age().orElse(null).value())
                .setEmailAddress(p.emailAddress().value())
                .setPassword(ByteString.copyFrom(p.password().value())).build();
    }

    private static List<String> middleNames(List<Person.MiddleName> list) {
        return list.stream().map(SimpleType::value).collect(Collectors.toList());
    }

    private static List<Person.MiddleName> middleNames(ProtocolStringList list) {
        return list.stream().map(MiddleName::of).collect(Collectors.toList());
    }

}
