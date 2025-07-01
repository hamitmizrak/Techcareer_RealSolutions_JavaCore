package com.hamitmizrak._04_week;

public class _03_JavaMemory_GarbarageCollection {

    public static void main(String[] args) {

        Person p1 = new Person("Ali");
        Person p2 = new Person("Veli");
        p1 = null; // Artık 'Ali' nesnesi referanssız
        p2 = null; // Artık 'Veli' nesnesi referanssız

        // Garbarage Collection
        // JVM’e çöp toplama tavsiyesi verir ama çalışacağı garanti değildir.
        System.gc(); // GC çalışması için öneride bulunuyoruz
        System.out.println("Program sonlandı.");
    }

}


// Person Class
class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name + " nesnesi garbage collector tarafından temizlendi.");
    }
}