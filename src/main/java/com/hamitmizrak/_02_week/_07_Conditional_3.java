package com.hamitmizrak._02_week;

public class _07_Conditional_3 {

    public static void conditional1(int number) {
        if (number == 0) {
            System.out.println("Sayı sıfır");
        } else if (number > 0) {
            System.out.println("Sayı pozitif");
        } else {
            System.out.println("Sayı negatif");
        }
    }

    // PSVM
    public static void main(String[] args) {

        int number = 0;

        conditional1(number);
    }
}
