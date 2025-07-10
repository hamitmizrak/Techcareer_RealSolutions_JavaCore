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
Local Inner Class
 Özellikler:
Sadece tanımlandığı metodun içinde kullanılabilir.
Genellikle küçük, tek seferlik işler için kullanılır.
 */

public class _02_3_localInnerClass {
    public void NestedDataPrint(){
        class InnerClass{
            public void innerDataPrint(){
                System.out.println("Local Inner Class");
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.innerDataPrint();
    }

} // end _02_1_Non_static__InnerClass


