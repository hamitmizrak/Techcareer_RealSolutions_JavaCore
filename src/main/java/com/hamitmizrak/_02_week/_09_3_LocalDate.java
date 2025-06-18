package com.hamitmizrak._02_week;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class _09_3_LocalDate {

    public static void localDateTimeTutorial(){

        LocalDateTime now= LocalDateTime.now();
        System.out.println("Şimdiki zaman: "+ now);

        System.out.println("Hour: "+ now.getHour());
        System.out.println("Minute: "+ now.getMinute());
        System.out.println("Second: "+ now.getSecond());
        System.out.println("Month: "+ now.getMonth());
        System.out.println("Year: "+ now.getYear());
    }

    // Date
    public static void localFormatterTutorials() {
        LocalDateTime now= LocalDateTime.now();
        Locale locale= new Locale("tr","TR");
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss",locale);
        System.out.println(now);
        System.out.println(now.format(dateTimeFormatter));
    }

    public static void main(String[] args) {
        localDateTimeTutorial();
        //localFormatterTutorials();
    }
}
