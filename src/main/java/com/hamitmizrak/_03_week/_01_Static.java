package com.hamitmizrak._03_week;

import com.hamitmizrak.utilty.SpecialColor;

// Static instance(Örnekleme) oluşturulmadan çağırdığımız nesnedir.
// Class.variable
// for example: Math.abs(-14)
public class _01_Static {

    // Field (static)
    public static int counter = 0;

    // static initialize
    static{
        System.out.println(SpecialColor.YELLOW+"Static Port yapıları hazırlanıyor."+SpecialColor.RESET);
    }

    // Constructor
    public _01_Static() {
        System.out.println(SpecialColor.BLUE+"Constructor Port yapıları hazırlanıyor."+SpecialColor.RESET);
        counter++;
    }

    // Method (static)
    public static double fieldResult(int x, int y) {
        return x * y;
    }


    // PSVM (Test)
    public static void main(String[] args) {

        // FIELD
        new _01_Static();
        System.out.println(_01_Static.counter);
        new _01_Static();
        System.out.println(_01_Static.counter);

        new _01_Static();
        new _01_Static();
        new _01_Static();
        System.out.println(_01_Static.counter);

        // METHOD
        double result = _01_Static.fieldResult(3, 4);
        System.out.println(result);


    }
}
