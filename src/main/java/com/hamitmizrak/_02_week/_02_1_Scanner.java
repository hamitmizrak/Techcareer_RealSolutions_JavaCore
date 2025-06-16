package com.hamitmizrak._02_week;

import java.util.Scanner;

public class _02_1_Scanner {

    /**
     String sonra Sayı gelirse normal akış devam eder.
      */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lütfen adınızı giriniz");
        String name = scanner.nextLine();
        System.out.println("Adınız: "+name);

        System.out.println("\nLütfen bir sayı giriniz");
        int numberData = scanner.nextInt();
        System.out.println("Girdiğiniz Sayı: "+numberData);

        // Scanner close
        scanner.close();

    }
}
