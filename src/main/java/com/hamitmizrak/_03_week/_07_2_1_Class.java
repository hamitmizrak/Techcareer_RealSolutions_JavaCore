package com.hamitmizrak._03_week;

import java.util.Objects;

// Bean Zorunludur, private, constructor
public class _07_2_1_Class {

    // Field
    private String name;
    private String surname;

    // Constructor (Parametresiz)
    public _07_2_1_Class() {
        this.name = "ad girmediniz";
        surname = "soyadı girmediniz";
    }

    // Constructor (Parametreli)
    public _07_2_1_Class(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // EQUALS-HASHCODE
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        _07_2_1_Class aClass = (_07_2_1_Class) o;
        return Objects.equals(name, aClass.name) && Objects.equals(surname, aClass.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }


    // TOSTRING
    // 1. alan: cast
    // 2. alan: nesneyi String'e çevir
    // 3. alan: parmak izi, class

    @Override
    public String toString() {
        return "_07_2_1_Class{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }


    // METHOD
    public String fullName() {
        return this.name + " " + this.surname;
    }

    // GETTER AND SETTER

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static void main(String[] args) {
        _07_2_1_Class aClass = new _07_2_1_Class();
        aClass.setName("Hamit");
        aClass.setSurname("Mızrak");

        // System.out.println(aClass.getName()+ " "+ aClass.getSurname());
        System.out.println(aClass);

        String result = aClass.fullName();
        System.out.println(result);
    }
}
