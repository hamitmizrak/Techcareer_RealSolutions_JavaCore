package com.hamitmizrak._03_week.access1;

public class Person {

    // Access Modifier
    public String publicField = "Public";
    protected String protectedField = "protected ";
    private String privateField = "private";
    String defaultField = "default";


    // PSVM
    // Aynı paketin Aynı Class
    public static void main(String[] args) {
        Person person= new Person();
        System.out.println(person.publicField);
        System.out.println(person.protectedField);
        System.out.println(person.privateField);
        System.out.println(person.defaultField);
    }
}
