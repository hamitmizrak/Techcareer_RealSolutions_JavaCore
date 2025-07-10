package com.hamitmizrak._03_week;

import com.hamitmizrak.utilty.SpecialColor;

public class _05_4_MatrixArray {

    // static
    private static int counter =0;

    public static void main(String[] args) {
        // Matrix
        int[][] matrix= new int[3][3]; // 3*3 = 9
        matrix[0][0]=1;
        matrix[0][1]=2;
        matrix[0][2]=3;
        matrix[1][0]=4;
        matrix[1][1]=5;
        matrix[1][2]=6;
        matrix[2][0]=7;
        matrix[2][1]=8;
        matrix[2][2]=9;

        // Klasik for Döngüsü (Iterative)
        System.out.println("\n" + SpecialColor.YELLOW + "Klasik for Döngüsü (Iterative)" + SpecialColor.RESET);
        for (int i = 0; i <matrix.length ; i++) { // Satır
            for (int j = 0; j <matrix[i].length ; j++) { // Sutun
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println(); // satır sonu
        }

        // for-each isimsel (enhanced for Loop)
        System.out.println("\n" + SpecialColor.YELLOW + "for-each isimsel (enhanced for Loop)" + SpecialColor.RESET);
        for(int[] satir : matrix){
            for(int eleman : satir){
                System.out.print(eleman+" ");
            }
            System.out.println();
        }

        // 3 lü for  10*10*10 = 1000
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    counter++;
                    System.out.println("sayac: "+counter+" : data");
                }
            }
        }
        System.out.println("Toplam Döngü sayısı: "+counter);
    }
}
