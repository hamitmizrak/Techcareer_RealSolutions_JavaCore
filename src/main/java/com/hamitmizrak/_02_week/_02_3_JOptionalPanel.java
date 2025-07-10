package com.hamitmizrak._02_week;

import javax.swing.*;

public class _02_3_JOptionalPanel {


    public static void main(String[] args) {

        // Kullanıcıdan Veri alır alınan veri String değerindedir.
        String ad = JOptionPane.showInputDialog("Adınızı giriniz:");
        System.out.println("Adınız: " + ad);

        // İşlem Sonucu Göster
        JOptionPane.showMessageDialog(null, ad+" İşlem başarıyla tamamlandı!");

        // Onay
        int secim = JOptionPane.showConfirmDialog(null, "Silmek istediğinize emin misiniz?", "Uyarı", JOptionPane.YES_NO_OPTION);

        if (secim == JOptionPane.YES_OPTION) {
            System.out.println("Kullanıcı evet dedi");
        }else {
            JOptionPane.showMessageDialog(null, "Kullanıcı hayır dedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
