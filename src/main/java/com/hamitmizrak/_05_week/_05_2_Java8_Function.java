package com.hamitmizrak._05_week;

public class _05_2_Java8_Function {

    public static void main(String[] args) {
        // Geleneksel yaklaşım (interface)
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("1- Çalışıyor...");
            }
        };
        // Çalıştır
        r1.run();

        // Lambda Expression
        Runnable r2 = () ->{System.out.println("2- Çalışıyor...");};
        r2.run();

        // Lambda Expression
        Runnable r3 = () ->System.out.println("3- Çalışıyor...");
        r3.run();
    }
}
