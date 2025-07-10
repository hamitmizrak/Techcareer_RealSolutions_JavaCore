package com.hamitmizrak._03_week;

// POJO : Plain Old Java Object
// POJO : Constructor olabilir veya olmayabilir
// Access Modifier(Erişim belirleyiciler) : public, private, protected, - gelebilir

public class _07_1_POJO_1_Class {

    // Field
    private String name;
    public String surname;

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
}
