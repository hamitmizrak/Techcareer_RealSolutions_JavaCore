package com.hamitmizrak._05_week;




@FunctionalInterface
interface Mesaj {
    void yaz(String msg);
}



public class _05_3_Java8_LambdaExpression {

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


        // FunctionalInterface
        // Kullanım
        //Mesaj m = (String msg) -> System.out.println("Gelen mesaj: " + msg);
        Mesaj m = (String msg) -> { System.out.println("Gelen mesaj: " + msg);};
        m.yaz("Merhaba Lambda");
    }
}
