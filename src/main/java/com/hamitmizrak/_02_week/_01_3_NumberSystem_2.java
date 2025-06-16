package com.hamitmizrak._02_week;

public class _01_3_NumberSystem_2 {

    // Number System ( 2-8-10-16)
    // 10 tabanındaki sayıyı, Verilen tabanı çevirmek
    public static void main(String[] args) {

        // 1. Tabana Çevirmek
        int number = 10;
        System.out.println("Binary: " + Integer.toBinaryString(number));
        System.out.println("Octal: " + Integer.toOctalString(number));
        System.out.println("Hexadecimal: " + Integer.toHexString(number));

        // 2. Sayı Dönüşümü
        int fromBinary= Integer.parseInt("1010",2);
        System.out.println(fromBinary);

        int fromOctal= Integer.parseInt("12",8);
        System.out.println(fromOctal);

        int fromHex= Integer.parseInt("a",16);
        System.out.println(fromHex);

    }
}
