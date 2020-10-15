package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import javax.json.bind.annotation.JsonbVisibility;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@JsonbVisibility(FieldPropertyVisibilityStrategy.class)
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private LocalDate birthday;

    @Column
    private String city;

    public String getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getCity() {
        return city;
    }

    boolean isValid() {
        return Objects.isNull(id) ||
                Objects.isNull(birthday) ||
                Objects.isNull(city) ||
                Objects.isNull(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                '}';
    }


}
