package com.hamitmizrak._02_week;

import java.util.Scanner;

public class _02_2_Scanner {

    /**
     Sayı sonra String  gelirse normal akış devam eder.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nLütfen bir sayı giriniz");
        int numberData = scanner.nextInt();
        System.out.println("Girdiğiniz Sayı: "+numberData);

        // Boşluğu almak
        scanner.nextLine();

        System.out.println("\nLütfen adınızı giriniz");
        String name = scanner.nextLine();
        System.out.println("Adınız: "+name);

        // Scanner close
        scanner.close();

    }
}
