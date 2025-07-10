package com.hamitmizrak._04_week;

import java.time.LocalDate;

/**
 * record sınıfı final'dir, kalıtım yapılamaz.
 * Tüm alanlar immutable olur.
 * record yalnızca constructor, static method ve alanları içerebilir.
 * record’da ekstra getter/setter yazılamaz.
 * Alanlara final demeye gerek yoktur, zaten sabittir.
 * Record içinde Constructor'ı Overloading yoktur. ===> static factory method
 * Recortta setName() görmeyeceğiz bunun yerine name() görürüz.
 */

// NOT: Aşağıdaki field alanalarında final private vardır.
// eg:  private final String name;
public record _02_Record(
        // Field
        String name,
        String surname,
        Long password,
        String email,
        LocalDate createdDate, // ===> final alanlar immutable olur
        boolean isLogin
) {

    // Yukarıdaki field alanı demek;
    /**
     private final String name;
     Constructor ekliyor.
     Sadece GETTER ekliyor.
     */

    // Constructor yapısını ekleyemeyiz ancak validation için;
    // Canonical Constructor (Otomatik gelen constructor'ı override edebiliriz)
    // Amaçımız Validation: auto Control
    public _02_Record {
        if(name ==null || name.isBlank()){
            throw new IllegalArgumentException("İsim boş geçilemez");
        }

        if(surname ==null || surname.isBlank()){
            throw new IllegalArgumentException("İsim boş geçilemez");
        }

        if(email ==null || email.isBlank()){
            throw new IllegalArgumentException("Email boş geçilemez");
        }

        if(!email.contains("@")){
            throw new IllegalArgumentException("Geçersiz Email");
        }
    }

    // static factory method
    public static _02_Record of(String name, String surname, String email){
        return new _02_Record(name,surname,441L, email, LocalDate.now(), true);
    }

    // toString
    @Override
    public String toString() {
        return "_02_1_Record{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                ", isLogin=" + isLogin +
                '}';
    }

    // psvm
    public static void main(String[] args) {

        // Instance
        _02_Record recordData1 = new _02_Record(
                "Hamit",
                "Mızrak", // Validation olarak "" bırakırsak istisna fırlatıyor
                444L,
                "hamitmizrak@gmail.com",
                java.time.LocalDate.of(2025,7,1),
                true

        );
        System.out.println(recordData1);
        System.out.println(recordData1.name);

        // static factory method
        _02_Record recordData2= _02_Record.of("Hamit","Mızrak","hamitmizrak@gmail.com");
        System.out.println(recordData2);
        System.out.println(recordData1.equals(recordData2));
    }
}
