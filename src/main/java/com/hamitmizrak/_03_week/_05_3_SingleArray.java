package com.hamitmizrak._03_week;

import java.util.Arrays;
import java.util.List;

// primitive type veya wrapper kullanabiliriz.
// Collections: Sadece Wrapper
public class _05_3_SingleArray {

    public static void main(String[] args) {

        // Array
        Integer[] data= new Integer[9];
        data[0]=2;
        data[1]=1;
        data[2]=3;
        data[3]=4;
        data[4]=7;
        data[5]=6;
        data[6]=5;
        // data[7]=8; // eklenmeyen elemana = 0
        data[8]=9;

        // Iterative

        // forach isimsel

        // Java 8 Stream forEach
        // Array'i Collections çevir
        System.out.println("\n*** java 8 forEach (stream.forEach) ***");
        Arrays.asList(data).stream().forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (stream.forEach.filter) ***");
        Arrays.asList(data).stream().filter(e->e!=null).forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (forEach) ***");
        Arrays.asList(data).forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (stream.forEach.Lambda) ***");
        List<Integer> dataList= Arrays.asList(data);
        dataList.stream().forEach(temp-> System.out.println("Elemanlar: "+temp));

    }
}
