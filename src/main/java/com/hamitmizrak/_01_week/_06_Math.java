package com.hamitmizrak._01_week;

public class _06_Math {

    /*
    Mathematics
    static bir yapıdadır.
     */
    public static void main(String[] args) {
        System.out.println("PI Sayısı: " +Math.PI);
        System.out.println("E Sayısı: " +Math.E);

        // Mutlak
        System.out.println("Mutlak Sayısı: " +Math.abs(-14));

        // Karekök
        System.out.println("Karekök Sayısı: " +Math.sqrt(64));

        // Üslü
        System.out.println("Üslü Sayısı: " +Math.pow(2,5));

        // Min
        System.out.println("Min Sayısı: " +Math.min(2,99));

        // Max
        System.out.println("Max Sayısı: " +Math.max(2,99));

        // Floor, Ceil, Round
        System.out.println("Floor Sayısı: " +Math.floor(6.9));
        System.out.println("Ceil Sayısı: " +Math.ceil(6.0001));
        System.out.println("round Sayısı: " +Math.round(8.4));
        System.out.println("round Sayısı: " +Math.round(8.5));

        // trigonometri
        System.out.println("sin: " +Math.sin(1));
        System.out.println("cos: " +Math.cos(1));
        System.out.println("tan: " +Math.tan(1));
        System.out.println("asin: " +Math.asin(1));

        System.out.println("log: " +Math.log(10));

        // Math bileşenleri içie kullanabiliriz.
        System.out.println(Math.sqrt(Math.abs(-25) ));  // NaN: Not A Number


    }

}
