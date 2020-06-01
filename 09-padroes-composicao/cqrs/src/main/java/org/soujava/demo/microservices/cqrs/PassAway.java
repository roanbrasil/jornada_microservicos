package org.soujava.demo.microservices.cqrs;

import java.util.function.Supplier;

public class PassAway implements Supplier<Person> {

    private final Person person;

    public PassAway(Person person) {
        this.person = person;
    }

    @Override
    public Person get() {
        return person;
    }
}