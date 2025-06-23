package com.hamitmizrak._03_week;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

// primitive type veya wrapper kullanabiliriz.
// Collections: Sadece Wrapper
public class _05_1_SingleArray {

    public static void main(String[] args) {

        int[] data= new int[9];
        data[0]=2;
        data[1]=1;
        data[2]=3;
        data[3]=4;
        data[4]=7;
        data[5]=6;
        data[6]=5;
        // data[7]=8; // eklenmeyen elemana = 0
        data[8]=9;

        // Array Metotları
        System.out.println("Kaç tane Eleman:" +data.length);
        System.out.println(data[0]);
        System.out.println(data[7]);

        // Hash Code
        System.out.println("Hash Code: "+data.hashCode());

        // for döngüsü (Iterative)
        System.out.println("\n*** for Iterative ***");
        for (int i = 0; i <data.length ; i++) {
            System.out.print(data[i]+" ");
        }

        // foreach isimsel
        System.out.println("\n*** foreach isimsel ***");
        for( int temp : data ){
            System.out.print(temp+" ");
        }

        // Sıralama
        System.out.println("\n*** foreach sorting ***");
        Arrays.sort(data);
        for( Integer temp : data ){
            System.out.print(temp+" ");
        }

        // Clone
        System.out.println("\n***clone***");
        int[] kopyalama= data.clone();
        System.out.println("\noriginal "+data[0]);
        System.out.println("kopya "+kopyalama[0]);

        // Equals
        System.out.println("\n*** equals ***");
        boolean isEquals= Arrays.equals(data,kopyalama);
        System.out.println("original == clone: "+isEquals);

        // Arrays.toString
        System.out.println("\n*** toString ***");
        System.out.println(Arrays.toString(kopyalama));
        System.out.println(Arrays.toString(kopyalama).substring(0,2));

        // Arrays.copyOf

    }
}
