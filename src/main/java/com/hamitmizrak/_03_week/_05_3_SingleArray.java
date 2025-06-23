package com.hamitmizrak._03_week;

import com.hamitmizrak.utilty.SpecialColor;

import java.util.Arrays;
import java.util.List;

// primitive type veya wrapper kullanabiliriz.
// Eğer biz datayı yazmazsak array otomatik olarak primitive type default:0 veya wrapper type default: null kullanabiliriz.
// Collections: Sadece Wrapper
public class _05_3_SingleArray {

    public static void main(String[] args) {

        // Array
        Integer[] data = new Integer[9];
        data[0] = 2;
        data[1] = 1;
        data[2] = 3;
        data[3] = 4;
        data[4] = 7;
        data[5] = 6;
        data[6] = 5;
        // data[7]=8; // eklenmeyen elemana = 0
        data[8] = 9;

        // Iterative null veya hepsi
        System.out.println("\n" + SpecialColor.YELLOW + "Iterative all" + SpecialColor.RESET);
        for (int i = 0; i < data.length; i++) {
            System.out.println("Eleman [ " + i + "]: " + data[i]);
        }

        // Iterative null olmayan
        System.out.println("\n" + SpecialColor.YELLOW + "Iterative null all" + SpecialColor.RESET);
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                System.out.println("Eleman [ " + i + "]: " + data[i]);
            }
        }

        // for-each isimsel (enhanced for Loop)
        System.out.println("\n" + SpecialColor.RED + "for-each null" + SpecialColor.RESET);
        for (Integer temp : data) {
            System.out.println("Eleman: " + temp);
        }

        System.out.println("\n" + SpecialColor.RED + "for-each null olmayan" + SpecialColor.RESET);
        for (Integer temp : data) {
            if (temp != null) {
                System.out.println("Eleman: " + temp);
            }
        }

        // Java 8 Stream forEach
        // Array'i Collections çevir
        System.out.println(SpecialColor.BLUE + "Java 8 forEach" + SpecialColor.RESET);
        System.out.println("\n*** java 8 forEach (stream.forEach) ***");
        Arrays.asList(data).stream().forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (stream.forEach.filter) ***");
        Arrays.asList(data).stream().filter(e -> e != null).forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (forEach) ***");
        Arrays.asList(data).forEach(System.out::println);

        System.out.println("\n*** java 8 forEach (stream.forEach.Lambda) ***");
        List<Integer> dataList = Arrays.asList(data);
        dataList.stream().forEach(temp -> System.out.println("Elemanlar: " + temp));

    }
}
