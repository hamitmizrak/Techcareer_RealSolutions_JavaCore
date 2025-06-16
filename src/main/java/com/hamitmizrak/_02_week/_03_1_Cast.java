package com.hamitmizrak._02_week;

public class _03_1_Cast {

    public static void main(String[] args) {
        // ✅ 1-) Widening Cast - Implicit Cast(Kapalı)
        // Küçük bir veriyi Büyük bir veriye taşıdığımızda veri kaybı olmaz.
        byte cast1Byte = 100;
        int cast1Int = cast1Byte;
        System.out.println(cast1Int);

        // ✅ 2- Narrowing Cast Explicit Cast (Açık)
        long cast2Long = 14515222555L;     //
        byte cast2Byte = (byte) cast2Long; // Veri kaybı oldu neden ?
        System.out.println(cast2Byte);

        // ✅ 3- Char => Int (ASCII, Unicode)
        char cast3Char = '~';
        int ascii = cast3Char;
        System.out.println(cast3Char + " sembolünün Ascii karşılığı: " + ascii);

        // ✅ 4- String => int
        String cast4String = "40";
        int castStringToInt1 = Integer.valueOf(cast4String);  // 1.YOL Bu
        int castStringToInt2 = Integer.parseInt(cast4String); // 2.YOL Bu aralarındaki farklar
        int cast4Int = 20;
        System.out.println(cast4String + cast4Int);
        System.out.println(cast4Int + castStringToInt1);
        System.out.println(cast4Int + castStringToInt2);

        // ✅ 5- int => String
        int cast5Int1 = 44;
        String castString1 = String.valueOf(cast5Int1);
        System.out.println(castString1 + 16);

        // ✅ 6- Automatic String alobarate
        String special = 16 + "";
        System.out.println(special + 14);


        // ✅ 7. Referans (Object) Türleri Arası Casting
        //🔹 A. Upcasting (Alt sınıftan üst sınıfa) → Otomatik
        class Hayvan {}
        class Kedi extends Hayvan {}
        Hayvan h = new Kedi();  // upcasting (otomatik)

        // ✅ 8. 🔹 B. Downcasting (Üst sınıftan alt sınıfa) → Manuel
        Hayvan animal = new Kedi();
        Kedi k = (Kedi) animal;      // downcasting (manuel ve güvenli)

    }
}
