package com.hamitmizrak._03_week;

import lombok.*;

import java.util.Objects;

// LOMBOK
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@ToString
// Bean Zorunludur, private, constructor
@Builder
@EqualsAndHashCode
public class _07_2_2_Class {

    // Field
    private String name;
    private String surname;

    // Constructor (Parametresiz)
    public _07_2_2_Class() {
        this.name = "ad girmediniz";
        surname = "soyadı girmediniz";
    }

    // Constructor (Parametreli)

    // EQUALS-HASHCODE

    // TOSTRING
    // 1. alan: cast
    // 2. alan: nesneyi String'e çevir
    // 3. alan: parmak izi, class

    // METHOD
    public String fullName() {
        return this.name + " " + this.surname;
    }

    // GETTER AND SETTER

    public static void main(String[] args) {
        /*_07_2_2_Class aClass = _07_2_2_Class.builder()
                .name("Hamit")
                .surname("Mızrak")
                .build();


        // System.out.println(aClass.getName()+ " "+ aClass.getSurname());
        System.out.println(aClass);

        String result = aClass.fullName();
        System.out.println(result);*/
    }
}
