package com.hamitmizrak._04_week;

import java.io.File;
import java.util.Date;

public class _04_2_File_Basic {

    private final static String FILE_PATH="E:\\1_Kodlar\\Java Se\\Techcareer_RealSolutions_JavaCore\\deneme.txt";

    public static void main(String[] args) {
        //File file = new File("./deneme.txt");
        File file = new File(FILE_PATH);


        if(file.isFile()){

            // can
            System.out.println("Dosya Okunabilir mi "+ file.canRead());
            System.out.println("Dosya Çalışabilir mi "+ file.canExecute());
            System.out.println("Dosya yazılabilinir mi "+ file.canWrite());

            System.out.println("Dosya mi "+ file.isFile());
            System.out.println("Dizin mi "+ file.isDirectory());


            System.out.println("Absolute Path: "+file.getAbsoluteFile());
            System.out.println("Dosya Adı: "+ file.getName());
            System.out.println("Parent: "+file.getParent());

            System.out.println("Free Space: "+file.getFreeSpace());
            System.out.println("Total Space: "+file.getTotalSpace());

            System.out.println("Length: "+file.length());

            // Modified
            long last= file.lastModified();
            Date date= new Date(last);
            System.out.println(last);
            System.out.println(date);

        }


    }
}
