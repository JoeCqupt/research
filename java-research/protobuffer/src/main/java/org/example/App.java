package org.example;

import org.example.person.Person;

import java.io.ByteArrayOutputStream;

/**
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {

        // serialize
        Person joe = Person.newBuilder()
                .setName("joe")
                .setAge(28)
                .setEmail("joe469391363@gmai.com")
                .build();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        joe.writeTo(baos);

        byte[] data = baos.toByteArray();

        // deserialize
        Person person = Person.parseFrom(data);
        System.out.println(person);
    }
}
