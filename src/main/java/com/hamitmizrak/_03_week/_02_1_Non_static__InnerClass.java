package com.hamitmizrak._03_week;

import com.hamitmizrak.utilty.SpecialColor;

/**
 SN      Tür	                                  Açıklama
 1. Non-static Inner Class (Üye sınıf)	   Dış sınıfın bir nesnesine bağlıdır
 2. Static Nested Class	                   Dış sınıfın nesnesine ihtiyaç duymaz
 3. Local Inner Class	                   Bir metodun veya blok yapının içinde tanımlanır
 4. Anonymous Inner Class	               İsimsiz, tek seferlik kullanılan sınıflardır
 */



/*
Özellikler ( Non-static Inner Class (Üye sınıf))
Dış sınıfın private üyelerine erişebilir.
Dış sınıfın bir örneği (instance) olmadan oluşturulamaz.
 */

public class _02_1_Non_static__InnerClass {
    // Dış class field
    private String message= "private Hoşgeldiniz,";

    public _02_1_Non_static__InnerClass() {
        System.out.println(SpecialColor.YELLOW+ "Constructor Dış Class "+SpecialColor.RESET);
    }

    // 1. Non-static Inner Class (Üye sınıf)	   Dış sınıfın bir nesnesine bağlıdır
    public class DataInnerClass {
        public DataInnerClass() {
            System.out.println(SpecialColor.BLUE+ "Constructor Iç Class "+SpecialColor.RESET);
        }

        //Inner Method
        public void dataPrint(){
            System.out.println("İç Sınıf "+message);
        }
    } // end DataInnerClass

    // PSVM
    public static void main(String[] args) {
        _02_1_Non_static__InnerClass.DataInnerClass dataInnerClass = new _02_1_Non_static__InnerClass().new DataInnerClass();
        dataInnerClass.dataPrint();
    }

} // end _02_1_Non_static__InnerClass


