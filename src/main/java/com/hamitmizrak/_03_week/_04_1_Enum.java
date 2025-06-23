package com.hamitmizrak._03_week;

/*
enum bir sınıf türüdür.
Her enum sabiti, aslında enum sınıfının bir nesnesidir.
Değerler default olarak public static final kabul edilir.
Genellikle switch-case, if, equals, == ile birlikte kullanılır.

Type Safe(Tür Güvenliği)
for Examples: Günler, aylar, rol modellemerinde
 */
public enum _04_1_Enum {
    PAZARTESI,SALI,CARSAMBA,PERSEMBE,CUMA,CUMARTESI,PAZAR

}


// PSVM
class MainEnum{
    public static void main(String[] args) {
        _04_1_Enum days= _04_1_Enum.PAZARTESI;
        System.out.println(days);
        String data= days.toString();
        System.out.println(data);
        System.out.println(days.ordinal());
    }
}