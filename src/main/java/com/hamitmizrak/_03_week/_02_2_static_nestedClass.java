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
Static Nested Class
Özellikler:
Dış sınıfın static üyelerine erişebilir.
Dış sınıfın nesnesine ihtiyaç duymaz.
 */

public class _02_2_static_nestedClass {
    // Dış class field
    private static String message= "private Static Hoşgeldiniz,";

    public _02_2_static_nestedClass() {
        System.out.println(SpecialColor.YELLOW+ "Constructor Dış Class "+SpecialColor.RESET);
    }

    // 2. Static Nested Class  Dış sınıfın nesnesine ihtiyaç duymaz
    public static class DataInnerClass {
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
        // Dış Class
        _02_2_static_nestedClass staticNestedClass = new _02_2_static_nestedClass();

        // Ic Class
        _02_2_static_nestedClass.DataInnerClass dataInnerClass = new _02_2_static_nestedClass.DataInnerClass();
        dataInnerClass.dataPrint();
    }

} // end _02_1_Non_static__InnerClass


