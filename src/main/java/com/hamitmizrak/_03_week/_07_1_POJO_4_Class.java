package com.hamitmizrak._03_week;

// POJO : Plain Old Java Object
// POJO : Constructor olabilir veya olmayabilir
// Access Modifier(Erişim belirleyiciler) : public, private, protected, - gelebilir

import lombok.*;

// LOMBOK
// @Data
@Getter
@Setter
@AllArgsConstructor // parametreli constructor
@NoArgsConstructor  // parametresiz constructor
public class _07_1_POJO_4_Class {

    // Field
    // @Getter @Setter
    private String name;
    private String surname;
    private int number;

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

    public static void main(String[] args) {
        _07_1_POJO_4_Class pojo4Class = new _07_1_POJO_4_Class();
        pojo4Class.setName("Adı");
        System.out.println(pojo4Class.getName());
    }
}
