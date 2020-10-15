package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.time.Year;

@Entity
public class LiveYear {

    @Id
    @Convert(YearConverter.class)
    private Year year;

    @Column
    private String city;

    @Column
    private int count;

    LiveYear(String city, Year year) {
        this.city = city;
        this.year = year;
    }

    LiveYear() {
    }

    public String getCity() {
        return city;
    }

    public int getYear() {
        return year.getValue();
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
    }

    @Override
    public String toString() {
        return "LiveYear{" +
                "year=" + year +
                ", count=" + count +
                '}';
    }
}
