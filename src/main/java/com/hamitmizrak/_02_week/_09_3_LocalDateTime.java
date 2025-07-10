package com.hamitmizrak._02_week;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class _09_3_LocalDateTime {

    public static void localDateTimeTutorial(){

        LocalDateTime now= LocalDateTime.now();
        System.out.println("Şimdiki zaman: "+ now);
        System.out.println("Kaçıncı Ay:"+now.getMonthValue());
        System.out.println("Hour: "+ now.getHour());
        System.out.println("Minute: "+ now.getMinute());
        System.out.println("Second: "+ now.getSecond());
        System.out.println("Month: "+ now.getMonth());
        System.out.println("Year: "+ now.getYear());
    }

    // LocalDateTime
    public static void localFormatterTutorials() {
        LocalDateTime now= LocalDateTime.now();
        Locale locale= new Locale("tr","TR");
        DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss",locale);
        System.out.println(now);
        System.out.println(now.format(dateTimeFormatter));
    }

    public static void localDateSet() {
        Locale locale = new Locale("tr", "TR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss", locale);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newData= now
                .withDayOfMonth(11) //
                .withMonth(12)  //
                .withYear(2029)
                .withHour(14)
                .withMinute(44)
                .withSecond(23);
        //System.out.println(now);
        System.out.println("Normal Tarih: "+now);
        System.out.println("Değiştirilmiş Tarih: "+newData.format(formatter));
    }


    public static void main(String[] args) {
        localDateSet();
        //localDateTimeTutorial();
        //localFormatterTutorials();
    }
}
