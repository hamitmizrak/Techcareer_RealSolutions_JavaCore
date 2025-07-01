package com.hamitmizrak._04_week;

import java.util.Objects;

public class _01_1_Classic_Class {

    // Field
    private String name;
    private String surname;
    private Long number;

    // Parametresiz Constructor
    public _01_1_Classic_Class() {
    }

    // Parametreli Constructor (1)
    public _01_1_Classic_Class(String name) {
        this.name = name;
    }

    // Parametreli Constructor (2)
    public _01_1_Classic_Class(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Parametreli Constructor (3)
    public _01_1_Classic_Class(Long number, String surname, String name) {
        this.number = number;
        this.surname = surname;
        this.name = name;
    }

    // toString()
    @Override
    public String toString() {
        return "_01_1_Classic_tutorials{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", number=" + number +
                '}';
    }


    // equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        _01_1_Classic_Class that = (_01_1_Classic_Class) o;
        return Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(number, that.number);
    }

    // HashCode
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, number);
    }

    // Builder
}
