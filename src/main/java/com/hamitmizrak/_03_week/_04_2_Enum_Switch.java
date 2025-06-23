package com.hamitmizrak._03_week;

/*
enum bir sınıf türüdür.
Her enum sabiti, aslında enum sınıfının bir nesnesidir.
Değerler default olarak public static final kabul edilir.
Genellikle switch-case, if, equals, == ile birlikte kullanılır.
 */

// HTTP Durum Kodları:  OK(200), NOT_FOUND(404), SERVER_ERROR(500);
// Kullanıcı Rolü:   ADMIN, MODERATOR, USER
// Sipariş Durumu:  HAZIRLANIYOR, KARGOLANDI, TESLIM_EDILDI, IPTAL_EDILDI
public enum _04_2_Enum_Switch {
    AKTIF,PASIF,BEKLEME
}

// PSVM
class EnumSwitch{
    public static void main(String[] args) {
        _04_2_Enum_Switch aSwitch= _04_2_Enum_Switch.AKTIF;

        // Switch (Lambda Expression)
        switch (aSwitch){
            case AKTIF -> System.out.println("Aktif Durumda");
            case PASIF -> System.out.println("Pasif Durumda");
            case BEKLEME -> System.out.println("Bekleme Durumda...");
        }
    }
}