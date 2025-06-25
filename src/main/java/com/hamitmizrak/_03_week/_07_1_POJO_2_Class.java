package com.hamitmizrak._03_week;

// POJO : Plain Old Java Object
// POJO : Constructor olabilir veya olmayabilir
// Access Modifier(Erişim belirleyiciler) : public, private, protected, - gelebilir

public class _07_1_POJO_2_Class {

    // Field
    private String name;
    public String surname;
    public int number;

    // PARAMETRESİZ CONSTRUCTOR
    public _07_1_POJO_2_Class() {
    }

    // PARAMETRELİ CONSTRUCTOR
    public _07_1_POJO_2_Class(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // PARAMETRELİ CONSTRUCTOR (OVERLOADING)
    public _07_1_POJO_2_Class(String name, String surname, int number) {
        this.name = name;
        this.surname = surname;
        this.number = number;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
