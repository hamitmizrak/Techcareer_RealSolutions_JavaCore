package com.hamitmizrak.access2;

import com.hamitmizrak.access1.Person;

public class Main3 {
    // PSVM
    // Farklı paketin Farklı Class
    public static void main(String[] args) {
        Person person= new Person();
        System.out.println(person.publicField);
        // System.out.println(person.protectedField);
        // System.out.println(person.privateField);
        // System.out.println(person.defaultField);
    }
}
