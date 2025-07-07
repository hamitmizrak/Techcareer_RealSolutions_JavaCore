package com.hamitmizrak._05_week.oop._3_inheritancex;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// LOMBOK
@Getter
@Setter
public class Person {
    private int id;
    private String name;
    private String surname;
    private String tcNumber;
    private Date createdDate;

    // Constructor (Parametresiz)
    public Person() {
    }

    // Constructor (Parametreli)
    public Person(int id, String name, String surname, String tcNumber, Date createdDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tcNumber = tcNumber;
        this.createdDate = createdDate;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tcNumber='" + tcNumber + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}