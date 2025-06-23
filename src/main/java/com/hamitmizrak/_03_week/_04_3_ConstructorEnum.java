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

// interface
interface dataPrint{
    void print();
}

public enum _04_3_ConstructorEnum implements dataPrint {

    // Variable
   SUCCESS(200),CREATED(201), NOT_FOUND(404), INTERNAL_ERROR(500), BAD_REQUEST(400);

    // Field
    // 1.Kullanım Final: Değişken sabitlemek
    // 2.Kullanım Final: SETTER gelmemesi için (SETTER, Safe Type)
    private final int kod;

    // Constructor private: Instance oluşmasını engellemek
    // Creation Design Pattern (Singleton Design Pattern)
    private _04_3_ConstructorEnum(int kod) {
        this.kod = kod;
    }

    // Method
    public boolean isPassiveGateway(){
        return this == SUCCESS || this == CREATED;
    }

    // Getter
    public int getKod() {
        return kod;
    }

    // Override
    @Override
    public void print() {
        System.out.println("Result"+this.getKod());
    }
}

class EnumMain{
    public static void main(String[] args) {
        System.out.println(_04_3_ConstructorEnum.NOT_FOUND);
        System.out.println(_04_3_ConstructorEnum.NOT_FOUND.getKod());
        System.out.println(_04_3_ConstructorEnum.NOT_FOUND+ "("+_04_3_ConstructorEnum.NOT_FOUND.getKod()+")");

     // Method
     // boolean result=  _04_3_ConstructorEnum.isPassiveGateway();
    }
}