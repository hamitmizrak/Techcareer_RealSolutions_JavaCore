package com.hamitmizrak._03_week;

import java.util.Arrays;
import java.util.List;

// primitive type veya wrapper kullanabiliriz.
// Collections: Sadece Wrapper
public class _05_3_SingleArray {

    public static void main(String[] args) {

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

        System.out.println("\n*** for Iterative ***");
        // for döngüsü (Iterative)
        for (int i = 0; i <data.length ; i++) {
            System.out.print(data[i]+" ");
        }

        System.out.println("\n*** foreach isimsel ***");
        // foreach isimsel
        for( Integer temp : data ){
            System.out.print(temp+" ");
        }

        System.out.println("\n*** java 8 forEach ***");
        // Java 8 Stream forEach
        //List<int[]> dataList= Arrays.asList(data);
        // List<Integer> dataList= Arrays.asList(data).stream().forEach(System.out::print);
        List<Integer> dataList=   Arrays.asList(data);
        System.out.println(dataList);

        System.out.println("\n*** foreach sorting ***");
        // Sıralama
        Arrays.sort(data);
        for( Integer temp : data ){
            System.out.print(temp+" ");
        }
    }
}
