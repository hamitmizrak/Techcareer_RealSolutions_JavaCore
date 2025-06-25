package com.hamitmizrak.access2;

import com.hamitmizrak.access1.Main1;

public class Main4 {
    // PSVM
    // Farklı paketin Farklı Class
    public static void main(String[] args) {
        Main1 person= new Main1();
        System.out.println(person.publicField);
        // System.out.println(person.protectedField);
        // System.out.println(person.privateField);
        // System.out.println(person.defaultField);
    }
}
