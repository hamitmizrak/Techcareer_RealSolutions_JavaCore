package com.hamitmizrak._02_week;

public class _08_Loop {

    public static void forLoop() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }

    public static void whileLoop() {
        int i = 1;
        while (i <= 10) {
            System.out.print(i + " ");
            i++;
        }
    }

    public static void doWhileLoop() {
        int i = 1;
        do{
            System.out.print(i + " ");
            i++;
        }while (i <= 10);
    }

    public static void main(String[] args) {
        forLoop();
        System.out.println();
        whileLoop();
        System.out.println();
        doWhileLoop();
    }

    // Array for each
    // Java 8 gelen forEach
}
