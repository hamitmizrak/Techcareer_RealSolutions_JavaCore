package com.hamitmizrak._02_week;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class _09_1_Date {

    // Date
    public static void dateTutorials() {
        Date date = new Date();
        System.out.println("Şu andaki zaman: " + date);
        System.out.println("1 ocak 1970: " + date.getTime());
        System.out.println("Year: " + date.getYear());
        System.out.println("Year: " + (1900 + date.getYear()));
        System.out.println("Month: " + date.getMonth());     // ay: Sıfırdan başlar
        System.out.println("Day: " + date.getDay());        //
        System.out.println("Ayın Date: " + date.getDate()); //
        System.out.println("Hours: " + date.getHours());    //
        System.out.println("Minute: " + date.getMinutes()); //
        System.out.println("Second: " + date.getSeconds()); //
    }

    // DateFormatter

    public static void dateToFormatter() {
        Date now= new Date();
        now.setHours(15);

        Locale locale= new Locale("tr","TR");

        // 1.YOL (18.06.2025 20:16)
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat();
        //String formattedToString = simpleDateFormat.format(now);

        // 2.YOL
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMM",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("MMMM-yyyy-",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM-dd",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM-dd hh:mm:ss",locale);
        //SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss",locale);
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MMMM-dd HH:mm:ss zzzz",locale);
        String formattedToString = simpleDateFormat.format(now);
        System.out.println(formattedToString);

    }

    public static void main(String[] args) {
       // dateTutorials();
        dateToFormatter();
    }
}
