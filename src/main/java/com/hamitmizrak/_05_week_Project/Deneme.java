package com.hamitmizrak._05_week_Project;


import lombok.Data;

/**
 *
 */
@Data
public class Deneme {

    private String ad;
    private int yas;

    public static void main(String[] args) {
        Deneme deneme = new Deneme();
        deneme.setAd("Hamit");
        deneme.setYas(35);
        System.out.println(deneme.getAd() + " - " + deneme.getYas());
    }


}

