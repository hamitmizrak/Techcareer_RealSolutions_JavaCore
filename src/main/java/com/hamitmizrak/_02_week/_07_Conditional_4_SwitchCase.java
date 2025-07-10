package com.hamitmizrak._02_week;

public class _07_Conditional_4_SwitchCase {

    public static void conditional1(int number) {
        if (number == 0) {
            System.out.println("Sayı sıfır");
        } else if (number == 1) {
            System.out.println("Sayı 1");
        } else if (number == 2) {
            System.out.println("Sayı 2");
        } else if (number == 3) {
            System.out.println("Sayı 3");
        } else if (number == 4) {
            System.out.println("Sayı 4");
        } else if (number == 5) {
            System.out.println("Sayı 5");
        } else {
            System.out.println("Sayı 0<=X<=5 dışında");
        }
    }

    public static void conditional2(int number) {
        switch (number){
            case 0:
                System.out.println("Sayı sıfır");
                break;
            case 1:
                System.out.println("Sayı 1");
                break;
            case 2:
                System.out.println("Sayı 2");
                break;
            case 3:
                System.out.println("Sayı 3");
                break;
            case 4:
                System.out.println("Sayı 4");
                break;
            case 5:
                System.out.println("Sayı 5");
                break;
            default:
                System.out.println("Sayı 0<=X<=5 dışında");
                break;
        }
    }

    // PSVM
    public static void main(String[] args) {
        int number = 5;
        conditional1(number);
        conditional2(number);
    }
}
