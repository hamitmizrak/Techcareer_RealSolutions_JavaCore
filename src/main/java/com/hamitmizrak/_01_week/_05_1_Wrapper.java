package com.hamitmizrak._01_week;

public class _05_1_Wrapper {

    /**
     Wrapper Types;
     1-) Heap Memory kullanır
     2-) Yavaştır Stack hafızaya göre
     3-) null değer alabiliriz.
     */
    public static void main(String[] args) {
        
        // Tamsayılar
        Byte wrapperByte =127;          
        Short wrapperShort=128;
        Integer wrapperInt=445525125;
        Long wrapperLong=4455251252L;
        
        // Virgüllü Sayı
        Float wrapperFloat=14.53f;
        Double wrapperDouble=new Double(14.56);

        // diğerleri
        Boolean wrapperBoolean=true;
        Character wrapperChar='&';
        System.out.println(wrapperChar);

        wrapperChar='\u1245';
        System.out.println(wrapperChar);
        
        // Wrapper type null değer alabilir.
        wrapperChar=null;

        // Primitive türden Wrapper çevirmek Boxing diyoruz.
    }
}
