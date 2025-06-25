package com.hamitmizrak.access1;

public class Main1 {

    // Access Modifier
    public String publicField = "Public";
    protected String protectedField = "protected ";
    private String privateField = "private";
    String defaultField = "default";


    // PSVM
    // Aynı paketin Aynı Class
    public static void main(String[] args) {
        Main1 person= new Main1();
        System.out.println(person.publicField);
        System.out.println(person.protectedField);
        System.out.println(person.privateField);
        System.out.println(person.defaultField);
    }
}
