package com.hamitmizrak._01_week;

public class _04_1_Primitive {

    /**
     Primitive Types;
     1-) Stack Memory kullanır
     2-) Hızlıdır
     3-) null değer alamaz
     4-) OOP için bunu boxing yapmak zorundayız.
     */
    public static void main(String[] args) {


        // Tamsayılar
        byte primitiveByte=127;           // -128   <=SAYI <= +127   (1 Byte = 8 bit 2^7)
        short primitiveShort=128;         // -32768 <=SAYI <= 32767  (2 Byte )
        int primitiveInt=445525125;       // -2³¹   <=SAYI <= 2³¹-1  (4 Byte )
        long primitiveLong=4455251252L;   // -2⁶³   <=SAYI <= 2⁶³-1  (8 Byte )


        // Virgüllü Sayı
        float primitiveFloat=14.53f;     //  4 byte	~7 basamak	0.0f
        double primitiveDouble=14.53f;   // 8 byte	~15 basamak	0.0d

        // diğerleri
        boolean primitiveBoolean=true; // 3>1
        char primitiveChar='&';
        System.out.println(primitiveChar);

        primitiveChar='\u1245';
        System.out.println(primitiveChar);

        // primitiveChar=null; // null veremezsiniz.

    }
}
