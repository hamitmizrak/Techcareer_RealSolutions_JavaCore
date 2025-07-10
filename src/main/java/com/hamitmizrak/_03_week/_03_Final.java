package com.hamitmizrak._03_week;

// final sınıflar kalıtılamaz (inheritance yapılamaz).
final public class _03_Final {

    // final (Field)
    public static final double PI = 3.14159;
    // final anahtar kelimesi, bir değişkenin, metodun veya sınıfın değiştirilemez (immutable) olduğunu belirtir.

    // final (Method)
    public final void sesVer() {
        System.out.println("Hayvan sesi");
    }
    // final metodlar override edilemez. Alt sınıflarda değiştirilemez.
}
