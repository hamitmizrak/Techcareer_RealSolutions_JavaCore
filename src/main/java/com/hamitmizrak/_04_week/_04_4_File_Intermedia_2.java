package com.hamitmizrak._04_week;

import com.hamitmizrak.utilty.SpecialColor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;  //  ==> Kullanıcıdan girdi almak için

public class _04_4_File_Intermedia_2 {

    // Scanner: Kullanıcıdan veri almak için kullandığımız kütüphane
    private static final Scanner scanner = new Scanner(System.in);

    // Dosya yolu: Sabit bir path üzerinden dosya işlemlerini yapmak
    private static final String DEFAULT_PATH = "C:\\logs\\log.txt";

    // Path: java.nio.file paketten gelen yol nesnesidir,  modern API'ler için kullanmaktayız
    private static final Path PATH = Paths.get(DEFAULT_PATH);

    /// ////////////////////////////////////////////////////////
    // Constructor
    public _04_4_File_Intermedia_2() throws IOException {
        createFile();
    }

    /// ////////////////////////////////////////////////////////
    // Kullanıcıdan Seçim verisi almak
    private static void menu() {
        System.out.println("\n=== DOSYA İŞLEMLERİ===");
        System.out.println("1- Dosya Oluştur");
        System.out.println("2- Dosya Yaz");
        System.out.println("3- Dosya Oku");
        System.out.println("4- Dosya Kopyala");
        System.out.println("5- Dosya İsmini Taşı");
        System.out.println("6- Dosya Sil");
        System.out.println("7- Dosya Detayları");
        System.out.println("0- Çıkış");
        System.out.println("Seçiminiz: ");
    }

    // Kullanıcıdan Veri almak
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // Sayıyı çevrilmezse -1 dönsün
        }
    }

    // Döngüsel Method
    public static void allAction() throws IOException {
        while (true) {
            // Kullanıcı isteği
            menu();

            // Kullanıcıdan veri almak
            int choise = getChoice();

            // Dosya İşlemleri
            switch (choise) {
                // Lambda expression : isimsiz metot gibi düşünebiliriz.
                case 1 -> createFile();         // Dosya oluştur
                case 2 -> writeFile();         // Dosya yaz
                case 3 -> readFromFile();      // Dosya oku
                case 4 -> copyFile();          // Dosya kopyala
                case 5 -> moveFile();          // Dosya taşı
                case 6 -> deleteFile();        // Dosya sil
                case 7 -> showFileDetails();   // Dosya detaylarını göster
                case 0 -> {                     // Sistemden Çıkış
                    System.out.println(SpecialColor.RED + " Çıkış yapılıyor");
                    // System.exit(0);
                    return; // Program çık
                }
                default -> System.out.println("Geçersiz Seçim !!!!");
            }
        }
    }

    /// ///////////////////////////////////////////////////////
    ///
    ///  Path NEW_PATH = Paths.get(newPath);
    private static void newPath(Path NEW_PATH) throws IOException {
        if (Files.notExists(NEW_PATH)) {
            Files.createDirectories(NEW_PATH.getParent()); // Klasor yoksa oluştur
            Files.createFile(NEW_PATH); // Dosya yoksa oluştur
            System.out.println(SpecialColor.BLUE + "Dosya oluşturuldu " + SpecialColor.RESET + NEW_PATH);
        } else {
            System.out.println(SpecialColor.RED + "Dosya zaten mevcut " + SpecialColor.RESET + NEW_PATH);
        }
    }


    // DOSYA OLUŞTUR
    private static void createFile() throws IOException {
        try {
            Path filePath; // java.nio
            System.out.println("Yeni bir path'i girmek istiyor musunuz ? evet/hayır");
            String choise = scanner.nextLine().trim().toLowerCase();
            if (choise.equals("evet")) {
                // Kullanıcıdan yeni yol
                String userPathDirectory,userPathFileName;
                StringBuilder allPath= new StringBuilder();
                System.out.println("Lütfen oluşturmak istediğiniz dosyanın dizi yolunu giriniz.\n 'C:\\logs\\'");
                userPathDirectory = scanner.nextLine().trim();
                System.out.println("Lütfen oluşturmak istediğiniz dosyanın dizi yolunu giriniz.\n 'deneme'");
                userPathFileName = scanner.nextLine().trim();
                allPath.append("./") .append(userPathDirectory).append("\\").append(userPathFileName).append(".txt");
                // filePath = Paths.get(allPath.toString());
                String newPath=allPath.toString();
                Path NEW_PATH = Paths.get(newPath);
                // 1.YOL
                // Dosya var mı ?
                /*if (Files.notExists(NEW_PATH)) {
                    Files.createDirectories(NEW_PATH.getParent()); // Klasor yoksa oluştur
                    Files.createFile(NEW_PATH); // Dosya yoksa oluştur
                    System.out.println(SpecialColor.BLUE + "Dosya oluşturuldu " + SpecialColor.RESET + NEW_PATH);
                } else {
                    System.out.println(SpecialColor.RED + "Dosya zaten mevcut " + SpecialColor.RESET + NEW_PATH);
                }*/

                // 2.YOL
                newPath(NEW_PATH);
            } else {
                // Bu yolda, dosya var mı ? yoksa oluştur
                newPath(PATH);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    // DOSYA YAZ
    private static void writeFile() throws IOException {
        System.out.print(SpecialColor.YELLOW + "Dosyaya yazılacak metin: " + SpecialColor.RESET);
        String text = scanner.nextLine();
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH, StandardOpenOption.APPEND)) {
            bufferedWriter.write(text);
            bufferedWriter.newLine(); // Satır atlar
            System.out.println(SpecialColor.PURPLE + "Yazma İşlemi başarılı" + SpecialColor.RESET);
        } catch (IOException ioException) {
            System.out.println("Yazma Hatası: " + SpecialColor.RED + ioException.getMessage());
        }
    }

    // DOSYA OKU
    private static void readFromFile() throws IOException {
        try {
            Files.lines(PATH).forEach(System.out::println); // Java 8 Stream API Kullanımı
        } catch (IOException ioException) {
            System.out.println("Yazma Hatası: " + SpecialColor.RED + ioException.getMessage());
        }
    }

    // DOSYA KOPYALA (aynı klasörde dosya yaz)
    private static void copyFile() throws IOException {
        // Var olan dosyayı isim değiştirme
        Path replaceFile = Paths.get(DEFAULT_PATH.replace(".txt", "_clone.txt"));

        // Üzerine yaz
        try {
            Files.copy(PATH, replaceFile, StandardCopyOption.REPLACE_EXISTING); // Üzerine yaz
            System.out.println("Dosya Kopyalandı: " + replaceFile);
        } catch (IOException ioException) {
            System.out.println("Dosya Kopyalama Hatası: " + SpecialColor.RED + ioException.getMessage());
        }
    }

    // DOSYA KOPYALA (aynı klasörde dosya yaz)
    private static void moveFile() throws IOException {
        // Var olan dosyayı isim değiştirme
        Path replaceFile = Paths.get(DEFAULT_PATH.replace(".txt", "_moved.txt"));

        // Üzerine yaz
        try {
            Files.move(PATH, replaceFile, StandardCopyOption.REPLACE_EXISTING); // Üzerine yaz
            System.out.println("Dosya taşındı: " + replaceFile);
        } catch (IOException ioException) {
            System.out.println("Dosya Hatası: " + SpecialColor.RED + ioException.getMessage());
        }
    }

    // DOSYA SİLMEK
    private static void deleteFile() throws IOException {
        try {
            Files.deleteIfExists(PATH);
            System.out.println("Dosya Silindi: " + PATH);
        } catch (IOException ioException) {
            System.out.println("Dosya Silme: " + SpecialColor.RED + ioException.getMessage());
        }
    }

    /// /////////////////////////////////////////////
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

    // Uzantı ayrımak için yardımcı metot
    private static String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        return (lastIndex != -1) ? fileName.substring(lastIndex + 1) : "YOK";
    }

    // 1024MB = 1GB
    // 1024KB = 1MB
    // Uzantı ayrımak için yardımcı metot
    private static String toHumanReadable(long bytes) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (bytes >= 1024 * 1024 * 1024) {
            return decimalFormat.format((double) bytes / (1024 * 1024 * 1024)) + "GB";
        } else if (bytes >= 1024 * 1024) {
            return decimalFormat.format((double) bytes / (1024 * 1024)) + "MB";
        } else if (bytes >= 1024) {
            return decimalFormat.format((double) bytes / (1024)) + "KB";
        } else {
            return bytes + " B";
        }
    }

    // DOSYA HAKKINDA BİLGİLER
    private static void showFileDetails() throws IOException {
        // java.io.File objesi için nio'yu File çevir
        File file = PATH.toFile();

        if (file.exists()) {
            System.out.println("Adı: " + file.getName());
            System.out.println("Uzantısı: " + getFileExtension(file.getName()));
            System.out.println("Boyut: " + toHumanReadable(file.length()));
            System.out.println("Yolu: " + file.getAbsoluteFile());
            System.out.println("Parent: " + file.getParent());
            System.out.println("Okunabilir mi: " + file.canRead());
            System.out.println("Yazılabilinir mi: " + file.canWrite());
            System.out.println("Çalıştırtırılabilinir mi: " + file.canExecute());
            System.out.println("Gizli: " + file.isHidden());
            System.out.println("Dosya mı: " + file.isFile());
            System.out.println("Dizin mi(Klasör mü): " + file.isDirectory());
            System.out.println("Boş alan (GB): " + toHumanReadable(file.getFreeSpace()));
            System.out.println("Toplam alan (GB): " + toHumanReadable(file.getTotalSpace()));
        }
    }

    /// /////////////////////////////////////////////////////
    // PSVM
    public static void main(String[] args) throws IOException {
        new _04_4_File_Intermedia_2().allAction();
    } // end PSVM

} //end _04_4_File_Intermedia_2
