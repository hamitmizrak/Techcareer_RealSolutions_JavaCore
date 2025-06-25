package com.hamitmizrak._03_week;

import java.util.*;

public class _09_2_Collection_Set {

    // CITY ARRAYLIST -1
    public static Set<String> cityHashSet1() {
        Set<String> cities = new HashSet<>();
        cities.add("İstanbul");
        cities.add("İstanbul");
        cities.add("Ankara");
        cities.add("İzmir");
        cities.add("Bursa");
        cities.add("Antalya");
        cities.add("Konya");
        cities.add("Adana");
        cities.add("Mersin");

        // Collections (Karışık)
        //  Collections.shuffle(cities); // shuffle Lsit olmalı
        Collections.shuffle((List<?>) cities);

        // LIST FOR ITERATIVE
        // SET get kullanamıyoruz
        /*for (int i = 0; i < cities.size(); i++) {
            System.out.print(cities.get(i) + " ");
        }*/
        return cities;
    }


    // CITY ARRAYLIST-2
    public static Set<String> cityHashSet2() {
        // Arrays.asList() => Array'i Listeye çevir
        Set<String> cities = new HashSet<>(Arrays.asList(
                "İstanbul", "İstanbul", "Ankara", "İzmir", "Bursa", "Antalya", "Konya", "Adana", "Mersin"
        ));
        return cities;
    }

    // CITY LINKEDLIST -1
    public static Set<String> cityLinkedHashSet() {
        // Arrays.asList() => Array'i Listeye çevir
        Set<String> cities = new TreeSet<>(Arrays.asList(
                "İstanbul", "İstanbul", "Ankara", "İzmir", "Bursa", "Antalya", "Konya", "Adana", "Mersin"
        ));

        // Collections (Sıralama)
         // Collections.sort(cities);
        // LIST FOR-EACH
        for (String temp : cities) {
            System.out.print(temp + " ");
        }

        return cities;
    }


    // LIST TUTORIALS
    public static void setTutorials() {
        Set<String> dataList = cityHashSet2();

        // Iterator
        System.out.println("======= ITERATOR =======");
        Iterator iterator = dataList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Collections(shuffle: Rastgele)
        /*Collections.shuffle(dataList);*/

        // ForEach-1
        System.out.println("\n\n======= ForEach-1 (Lambda Expression) =======");
        dataList.stream().forEach((temp) -> {
            System.out.print(temp + " ");
        });

        // Collections (Ters)
       /* Collections.reverse(dataList);*/

        // ForEach-2
        System.out.println("\n\n======= ForEach-2 =======");
        dataList.forEach((temp) -> {
            System.out.print(temp + " ");
        });

        // Collections()
        // Collections.sort(dataList);

        // ForEach-2
        System.out.println("\n\n======= ForEach-3 (Method Referances) =======");
        dataList.forEach(System.out::print);

        System.out.println("\n\n======= For-Each-4  =======");
        // Collections()
       /* Collections.reverse(dataList);*/
        // For-Each
        for (String temp : dataList) {
            System.out.print(temp + " ");
        }

        System.out.println("\n\nEleman sayısı: " + dataList.size());
        System.out.println("Boş mu ?: " + dataList.isEmpty());

        //System.out.println("İlk eleman: " + dataList.get(0));
        //System.out.println("Verilen indisi Listeden Sil ?: " + dataList.remove(0));
        //dataList.clear();  // bundan sonra IndexOutOfBoundsException
        //System.out.println("İlk eleman: " + dataList.get(0));

        System.out.println("hashCode : " + dataList.hashCode());
        System.out.println("Var mı  ?: " + dataList.contains("İstanbul"));

        // Listeyi String'e çevir
        String listToString = dataList.toString();
        System.out.println(listToString);
    }


    public static void main(String[] args) {
        //cityArrayList1();
        //System.out.println();
        //cityLinkedList();
        setTutorials();
    }
}
