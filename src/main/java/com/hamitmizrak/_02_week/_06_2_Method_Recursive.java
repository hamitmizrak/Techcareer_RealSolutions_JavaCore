package com.hamitmizrak._02_week;

import com.hamitmizrak.utilty.SpecialColor;

import java.util.Scanner;

public class _06_2_Method_Recursive {

    // User
    public static int userData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz");
        int user = scanner.nextInt();
        return user;
    }

    // Faktöriyel Iterative
    public static long factoriyelIterative(int number) {
        long result = 1; // initiate data
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Faktöriyel Recursive
    public static long factoriyelRecursive(int number) {
        if (number == 0 || number == 1)
            return 1;
        return number * factoriyelRecursive(number - 1);
    }

    // Asal Iterative

    // Asal Recursive

    public static void main(String[] args) {
        // Monad  factoriyelIterative(userData()))
        //  _06_2_Method_Recursive.factoriyelIterative(userData());

        int number =userData();

        // Faktroriyel
        System.out.println(number+" sayısının faktöriyeli: Faktöriyel (Iterative): " + SpecialColor.YELLOW+ factoriyelIterative(number)+SpecialColor.RESET);

        System.out.println(number+" sayısının faktöriyeli: "+"Faktöriyel (Resursive): " + SpecialColor.YELLOW+factoriyelRecursive(number)+SpecialColor.RESET);

        // Asal SAyı
    }
}
