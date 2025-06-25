package com.hamitmizrak.access1;

public class Main2 {
    // PSVM
    // Aynı paketin Aynı Class
    public static void main(String[] args) {
        Main1 person= new Main1();
        System.out.println(person.publicField);
        System.out.println(person.protectedField);
        //System.out.println(person.privateField);
        System.out.println(person.defaultField);
    }
}
