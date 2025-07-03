package com.hamitmizrak._04_week;

import com.hamitmizrak.utilty.SpecialColor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

// LOMBOK
//@Log4j2
public class _04_3_File_Intermedia_1 {

    // Const
    private final static String FILE_PATH = "E:\\1_Kodlar\\Java Se\\Techcareer_RealSolutions_JavaCore\\log.txt";
    private final static Scanner scanner = new Scanner(System.in);

    // Parametresiz Constructor
    public _04_3_File_Intermedia_1() {
        logFileCreate();
    }

    // Create File
    private static void logFileCreate() {
        try {
            File file = new File(FILE_PATH);
            // Dosya yoksa oluştur
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(FILE_PATH + " adında dosya oluşturuldu");
            } else {
                System.out.println(FILE_PATH + SpecialColor.RED + " zaten böyle bir dosya var" + SpecialColor.RESET);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    } // end logFileCreate

    // LogDate
    private static String logDate() {
        // 1.YOL
        /*
        Locale locale = new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zzzz",locale);
        Date date = new Date();
        String changeToDate = simpleDateFormat.format(date).toString();
        return  changeToDate;
        */
        // 2.YOL
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss zzzz", new Locale("tr", "TR")).format(new Date()).toString();
    }

    // Writer
    private static void logToWriter() {
        // Eğer true denilmezse içindeki bütün yazıları siler ve en son eklenen kalır
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String nowDate = "[" + logDate() + "]";
            System.out.println("Lütfen birşeyler yazınız");
            scanner.nextLine(); // dummy Clean ()
            String value = scanner.nextLine();
            bufferedWriter.write(value);
            bufferedWriter.flush(); // Eğer cache belleğinde veri varsa tam zamanı yaz artık
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // Reader
    private static void logToReader() {
        StringBuilder stringBuilder = new StringBuilder();
        String rows = null, builderToString = ""; // satır

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            while ((rows = bufferedReader.readLine()) != null) {
                stringBuilder.append(rows).append("\n");
            }
            builderToString = stringBuilder.toString();
            System.out.println(SpecialColor.BLUE + builderToString + SpecialColor.RESET);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // Delete
    private static void logToDelete() {
        try {

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    private static void logAllAction() {
        while (true) {
            String allChooise = "\nLütfen seçim yapınız"
                    .concat("\n1-)Dosya oluştur")
                    .concat("\n2-)Dosya yaz")
                    .concat("\n3-)Dosya oku")
                    .concat("\n4-)Dosya sil")
                    .concat("\n0-)Çıkış");
            System.out.println(allChooise);
            int userChooise = scanner.nextInt();
            switch (userChooise) {
                case 1:
                    logFileCreate();
                    break;
                case 2:
                    logToWriter();
                    break;
                case 3:
                    logToReader();
                    break;
                case 4:
                    logToDelete();
                    break;
                case 0:
                    System.out.println("Çıkış yapılıyor");
                    break;
                default:
                    System.out.println("Doğru seçim yapınız");
                    break;
            }
        }
    }


    // PSVM
    public static void main(String[] args) {
        //_04_3_File_Intermedia fileIntermedia = new _04_3_File_Intermedia();
        logAllAction();
    }
}
