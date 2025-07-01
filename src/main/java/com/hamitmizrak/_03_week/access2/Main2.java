package com.hamitmizrak._03_week.access2;

import com.hamitmizrak._03_week.access1.Person;

public class Main2 extends  Person {

    // PSVM
    // Aynı paketin Aynı Class
    public static void main(String[] args) {
        Person person= new Person();
        System.out.println(person.publicField);
        //System.out.println(person.protectedField);
        //System.out.println(person.privateField);
        //System.out.println(person.defaultField);

        // instance
        Main2 main2 = new Main2();
        System.out.println(main2.protectedField);

    }
}
