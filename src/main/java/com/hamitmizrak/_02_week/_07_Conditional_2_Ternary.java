package com.hamitmizrak._02_week;

public class _07_Conditional_2_Ternary {

    public static void conditional1(int number) {
        if (number > 0) {
            System.out.println("Sayı pozitif");
        } else {
            System.out.println("Sayı negatif");
        }
    }

    // Ternary
    public static void conditional2(int number) {
        String result = (number > 0) ? "Sayı pozitif" : "Sayı negatif";
        System.out.println(result);
    }

    // PSVM
    public static void main(String[] args) {
        int number = 5;

        conditional1(number);
        conditional2(number);
    }
}
