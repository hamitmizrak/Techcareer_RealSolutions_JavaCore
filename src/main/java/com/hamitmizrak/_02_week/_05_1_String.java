package com.hamitmizrak._02_week;

import com.hamitmizrak.utilty.SpecialColor;

public class _05_1_String {

    public static void main(String[] args) {

        String value=" java ÖĞRENİYorum java ";
        System.out.println(value);

        // LENGTH
        System.out.println(SpecialColor.BLUE+"Harf sayısı: "+SpecialColor.RESET+  value.length());

        // TRIM
        System.out.println(SpecialColor.BLUE+"Trimlenmiş kelime: "+SpecialColor.RESET+  value.trim());

        // TRIM/LENGTH
        System.out.println(SpecialColor.BLUE+"Trim Harf sayısı: "+SpecialColor.RESET+  value.trim().length());

        // LOWERCASE
        System.out.println(SpecialColor.YELLOW+"Bütün harfler küçük: "+SpecialColor.RESET+  value.toLowerCase());

        // UPPERCASE
        System.out.println(SpecialColor.YELLOW+"Bütün harfler büyük: "+SpecialColor.RESET+  value.toUpperCase());

        String renameValue= value.trim();
        // STARTSWITH
        System.out.println(SpecialColor.GREEN+"-ile mi başlıyor: "+SpecialColor.RESET+  renameValue.startsWith("java"));

        // ENDSWITH
        System.out.println(SpecialColor.GREEN+"-ile mi bitiyor: "+SpecialColor.RESET+  renameValue.endsWith("Java"));

        // ISEMPTY
        System.out.println(SpecialColor.GREEN+"boş mu: "+SpecialColor.RESET+  renameValue.isEmpty());

        // ISBLANK
        System.out.println(SpecialColor.GREEN+"isBlank mu: "+SpecialColor.RESET+  renameValue.isBlank());


        // SUBSTRING
        System.out.println(renameValue);
        System.out.println(SpecialColor.PURPLE+"subString: "+SpecialColor.RESET+  renameValue.substring(1)); // subString => Sıfırdan başlar saymaya
        System.out.println(SpecialColor.PURPLE+"subString: "+SpecialColor.RESET+  renameValue.substring(1,3)); // subString => Sıfırdan başlar saymaya  1<=X<=3-1

        // charAt
        System.out.println(SpecialColor.GREEN+"charAt: "+SpecialColor.RESET+  renameValue.charAt(0));


        // HASHCODE
        System.out.println(SpecialColor.GREEN+"hashCode: "+SpecialColor.RESET+  renameValue.hashCode());

        // INDEXOF/ LASTINDEXOF
        System.out.println(SpecialColor.RED+"indexof: "+SpecialColor.RESET+  renameValue.indexOf("java"));
        System.out.println(SpecialColor.RED+"lastIndexof: "+SpecialColor.RESET+  renameValue.lastIndexOf("java"));


        // REPLACE
        System.out.println(SpecialColor.GREEN+"replace: "+SpecialColor.YELLOW+  renameValue.replace(renameValue,"değiştirildi"));

        // SPLIT
        // CONCAT
    }
}
