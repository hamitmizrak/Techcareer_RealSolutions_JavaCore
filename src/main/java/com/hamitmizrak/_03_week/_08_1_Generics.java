package com.hamitmizrak._03_week;

import java.util.ArrayList;
import java.util.List;

/*
Tip güvenliğini sağlar.
Casting ihtiyacını ortadan kaldırır.
Kodun yeniden kullanılabilirliğini artırır.
Derleme zamanında tip hatalarını yakalar.
*/
public class _08_1_Generics {
    public static void main(String[] args) {
        // Eğer Generics kullanmazsak type safe
        List data = new ArrayList();
        data.add("Hamit"); // String
        data.add(44); // Exception in thread "main" java.lang.ClassCastException

        //String name= (String)data.get(0);
        String name= (String)data.get(1);
        System.out.println(name);

        //int dataNumber= 55;
        //Object object = dataNumber;
    }
}
