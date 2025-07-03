package com.hamitmizrak._04_week;

import com.hamitmizrak.utilty.SpecialColor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;  // ==> NIO(Yeni dosya sistem API'leri için)
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;  //  ==> Kullanıcıdan girdi almak için

public class _04_4_File_Intermedia_2 {

    // Scanner: Kullanıcıdan veri almak için kullandığımız kütüphane
    private static final Scanner scanner = new Scanner(System.in);

    // Dosya yolu: Sabit bir path üzerinden dosya işlemlerini yapmak
    private static final String DEFAULT_PATH = "C:\\logs\\log.txt";

    // Path: java.nio.file paketten gelen yol nesnesidir,  modern API'ler için kullanmaktayız
    private static final Path PATH = Paths.get(DEFAULT_PATH);

    // Kullanıcıdan Seçim verisi almak
    private static void menu() {
        System.out.println("\n=== DOSYA İŞLEMLERİ===");
        System.out.println("1- Dosya Oluştur");
        System.out.println("2- Dosya Yaz");
        System.out.println("3- Dosya Oku");
        System.out.println("4- Dosya Kopyala");
        System.out.println("5- Dosya Taşı");
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
                case 1 -> createFile();  // Dosya oluştur
                case 2 -> writeFile();  // Dosya yaz
                case 3 -> readFromFile();  // Dosya oku
                case 4 -> copyFile();  // Dosya kopyala
                case 5 -> moveFile();  // Dosya taşı
                case 6 -> deleteFile();  // Dosya sil
                case 7 -> showFileDetails();  // Dosya detaylarını göster
                case 0 -> logout();  // Sistemden Çıkış
            }
        }
    }

    /// ///////////////////////////////////////////////////////
    // DOSYA OLUŞTUR
    private static void createFile() throws IOException{
        // Bu yolda, dosya var mı ? yoksa oluştur
        if(Files.notExists(PATH)){
            Files.createDirectories(PATH.getParent()); // Klasor yoksa oluştur
            Files.createFile(PATH); // Dosya yoksa oluştur
            System.out.println(SpecialColor.BLUE+ "Dosya oluşturuldu "+ SpecialColor.RESET+PATH);
        }else{
            System.out.println(SpecialColor.RED+ "Dosya zaten mevcut "+ SpecialColor.RESET+PATH);
        }
    }


    // DOSYA YAZ
    private static void writeFile() throws IOException{
        System.out.print(SpecialColor.YELLOW+ " Dosyaya yazılacak metin: "+SpecialColor.RESET);
        String text = scanner.nextLine();
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(PATH, StandardOpenOption.APPEND)){
            bufferedWriter.write(text);
            bufferedWriter.newLine(); // Satır atlar
            System.out.println(SpecialColor.PURPLE+ "Yazma İşlemi başarılı"+SpecialColor.RESET);
        }catch (IOException ioException){
            System.out.println("Yazma Hatası: "+SpecialColor.RED+ioException.getMessage());
        }
    }


     /// /////////////////////////////////////////////////////
    // PSVM
    public static void main(String[] args) {
        allAction();
    }

} //end _04_4_File_Intermedia_2
