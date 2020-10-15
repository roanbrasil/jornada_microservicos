package org.soujava.demo.microservices.cqrs;

import java.util.function.Supplier;

public class Born implements Supplier<Person> {

    private final Person person;

    public Born(Person person) {
        this.person = person;
    }

    @Override
    public Person get() {
        return person;
    }
}
