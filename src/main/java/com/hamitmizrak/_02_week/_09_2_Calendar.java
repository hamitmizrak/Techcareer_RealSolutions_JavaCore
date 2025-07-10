package com.hamitmizrak._02_week;

import java.util.Calendar;


/**
 Calendar: new Date'e alternatif olarak gelmiştir */
public class _09_2_Calendar {

    public static void calendarDate(){
        Calendar cal = Calendar.getInstance();

        System.out.println("Şu an: " + cal.getTime());

        // Tarih parçalayıp yaz
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println("Tarih: " + day + "/" + month + "/" + year);

        // 10 gün ekle
        cal.add(Calendar.DAY_OF_MONTH, 10);
        System.out.println("10 gün sonra: " + cal.getTime());

        // Saat ayarla
        cal.set(Calendar.HOUR_OF_DAY, 15);
        cal.set(Calendar.MINUTE, 30);
        System.out.println("Saat ayarı sonrası: " + cal.getTime());

    }

    public static void main(String[] args) {
        calendarDate();
    }
}
