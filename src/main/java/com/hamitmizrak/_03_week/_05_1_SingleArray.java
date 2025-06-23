package com.hamitmizrak._03_week;

import java.util.Arrays;

// primitive type kullanabiliriz.
public class _05_1_SingleArray {

    public static void main(String[] args) {

        int[] array= new int[9];
        array[0]=2;
        array[1]=1;
        array[2]=3;
        array[3]=4;
        array[4]=7;
        array[5]=6;
        array[6]=5;
        // array[7]=8; // eklenmeyen elemana = 0
        array[8]=9;

        // Array Metotları
        System.out.println("Kaç tane Eleman:" +array.length);
        System.out.println(array[0]);
        System.out.println(array[7]);

        // Hash Code
        System.out.println("Hash Code: "+array.hashCode());

        // for döngüsü (Iterative)
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }

        System.out.println("\n*** foreach isimsel ***");
        // foreach isimsel
        for( int temp : array ){
            System.out.print(temp+" ");
        }

        System.out.println("\n*** java 8 forEach ***");
        // Java 8 Stream forEach

        System.out.println("\n*** foreach sorting ***");
        // Sıralama
        Arrays.sort(array);
        for( int temp : array ){
            System.out.print(temp+" ");
        }

        // Clone

        // Equals

    }
}
