package com.hamitmizrak._04_week;

import java.io.File;
import java.util.Date;

public class _04_2_File_Basic {

    private final static String FILE_PATH="E:\\1_Kodlar\\Java Se\\Techcareer_RealSolutions_JavaCore\\deneme.txt";

    public static void main(String[] args) {
        //File file = new File("./deneme.txt");
        File file = new File(FILE_PATH);


        if(file.isFile()){
            // CAN
            System.out.println("+++ CAN +++");
            System.out.println("Okunabilinir mi? " + file.canRead());
            System.out.println("Yazılabilinir mi? " + file.canWrite());
            System.out.println("Çalışabilinir mi ? " + file.canExecute());

            System.out.println("+++ IS +++");
            System.out.println("Dizin mi? " + file.isDirectory());
            System.out.println("Dosya mi? " + file.isFile());
            System.out.println("Gizli Dosya mi? " + file.isHidden());

            System.out.println("+++ GET +++");
            System.out.println("Boş  HDD kalan alan? " + file.getFreeSpace());
            System.out.println("Name " + file.getName());
            System.out.println("getParent " + file.getParent());
            System.out.println("getAbsoluteFile " + file.getAbsoluteFile());
            System.out.println("Toplam HDD " + file.getTotalSpace());

            System.out.println("+++ SET +++");
            System.out.println("setExecutable " + file.setExecutable(false));
            System.out.println("setReadable " + file.setReadable(false));
            System.out.println("setWritable " + file.setWritable(false));

            System.out.println("+++ CAN +++");
            System.out.println("Okunabilinir mi? " + file.canRead());
            System.out.println("Yazılabilinir mi? " + file.canWrite());
            System.out.println("Çalışabilinir mi ? " + file.canExecute());

            System.out.println("+++ INFO +++");
            System.out.println("length ? " + file.length());

            // Modified
            long last= file.lastModified();
            Date date= new Date(last);
            System.out.println(last);
            System.out.println(date);

        }


    }
}
