package com.hamitmizrak._02_week;

/*
✅ Checked Exception Nedir?
Java tarafından zorunlu tutulur. Derleyici sizi uyarır.

📌 Örnekler:
IOException → dosya erişimi
SQLException → veritabanı hataları
ParseException → tarih dönüşüm hatası
 */


/*
✅ Unchecked Exception Nedir?
Derleyici sizi zorlamaz, ama çalışma zamanında program çökerse hatayı gösterir.

📌 Örnekler:
ArithmeticException → 10 / 0
NullPointerException
ArrayIndexOutOfBoundsException
NumberFormatException
 */

public class _10_2_CustomException extends Exception {

    // Constructor
    public _10_2_CustomException(String message) {
        super(message);
    }
}


class MainTestException {
    public static void main(String[] args) throws _10_2_CustomException {

        try {
            int a = 5 / 0;
        } catch (Exception e) {
            throw new _10_2_CustomException("Burada istisna var");
        }
    }


}
