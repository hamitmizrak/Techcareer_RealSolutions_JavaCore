package com.hamitmizrak._03_week;

import java.util.ArrayList;
import java.util.List;

// Bounded Generics (Generics Sınırlamalar)
// public class _08_4_Generics<T extends Number> {
public class _08_7_Generics_Wilcard<T extends String> {

    // METHOD
    public static void printDataNonWilcard(List<String> list){
        for(String temp : list){
            System.out.print(temp+" ");
        }
    }

    public static void printDataWilcard(List<?> list){
        for(Object temp : list){
            System.out.print(temp+" ");
        }
    }

    // Wilcard : Number
    public static void printDataUpperBound(List<? extends Number> list){
        for(Object temp : list){
            System.out.print(temp+" ");
        }
    }

    // ADD LIST
    public static void addList(){
        List<String> city = new ArrayList<>();
        city.add("Malatya");
        city.add("Bingöl");
        city.add("Elazığ");
        city.add("Ankara*3");
        city.add("İstanbul*2");
        city.add("Hatay");
        city.add("İskenderun");

        printDataNonWilcard(city);
        System.out.println("\n=======");
        printDataWilcard(city);

        List<Integer> number = new ArrayList<>();
        for (int i = 1; i <5 ; i++) {
            number.add(i);
        }
        System.out.println("\n=======");
        printDataWilcard(number);
    }


    // PSVM
    public static void main(String[] args) {
        addList();
    }
}

