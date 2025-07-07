package com.hamitmizrak._05_week.oop._4_abstractx;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
abstract public class Person implements IPerson, Serializable {
    protected int id;
    protected String name;
    protected String surname;
    protected String tcNumber;
    protected Date createdDate;

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

    // Gövdesiz Metot
    // Bu classta en az 1 tane gövdesiz metot olduğu için mutlaka class abstract olmak zorunda
    // Tersi doğru değildir.
    abstract public void specialData();

    // GÖVDELİ METOTLAR
    @Override
    public void fullName() {

    }

    @Override
    public boolean tcNumberValidation(Long tcNumber) {
        return false;
    }

    @Override
    public boolean isGender(String gender) {
        return false;
    }
}