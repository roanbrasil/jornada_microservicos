package org.soujava.demo.microservices.cqrs;

import jakarta.nosql.mapping.Column;
import jakarta.nosql.mapping.Convert;
import jakarta.nosql.mapping.Entity;
import jakarta.nosql.mapping.Id;

import java.time.Year;

@Entity
public class CityControl {

    @Id
    @Convert(YearConverter.class)
    private Year year;

    @Column
    private String city;

    @Column
    private int count;

    CityControl(String city, Year year) {
        this.city = city;
        this.year = year;
    }

    CityControl() {
    }

    public int getYear() {
        return year.getValue();
    }

    public String getCity() {
        return city;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        this.count++;
    }

    public void decrement() {
        this.count--;
    }

    @Override
    public String toString() {
        return "CityControl{" +
                "city='" + city + '\'' +
                ", year=" + year +
                ", count=" + count +
                '}';
    }
}
