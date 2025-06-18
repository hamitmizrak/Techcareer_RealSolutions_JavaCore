package com.hamitmizrak._02_week;


import com.hamitmizrak.utilty.SpecialColor;

public class _08_2_SwichCase_IfElse_NanoTime {

    // ifElseNanoTime
    public static void ifElseNanoTime(){
        int testValue=8;

        // If Else Zaman Ölçüsü
        long startIf= System.nanoTime();

        for (int i = 0; i <1_000_000; i++) {
            if(testValue ==1){}
            else if(testValue==2){}
            else if(testValue==3){}
            else if(testValue==4){}
            else if(testValue==5){}
            else if(testValue==6){}
            else if(testValue==7){}
            else if(testValue==8){}
            else if(testValue==9){}
            else if(testValue==10){}
            else{}
        }
        long endIf= System.nanoTime();
        long durationTime= endIf-startIf;
        System.out.println(SpecialColor.BLUE+ "If-Else Süresi (ns):\t "+SpecialColor.RESET+SpecialColor.YELLOW+durationTime+SpecialColor.RESET);

    }


    // switchCaseNanoTime
    public static void switchCaseNanoTime(){
        int testValue=8;

        // If Else Zaman Ölçüsü
        long startSwitch= System.nanoTime();

        for (int i = 0; i <1_000_000; i++) {
            switch (testValue) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    break;
            }
        }
        long endSwitch= System.nanoTime();
        long durationTime= endSwitch-startSwitch;
        System.out.println(SpecialColor.BLUE+ "Switch Süresi (ns): \t"+SpecialColor.RESET+SpecialColor.YELLOW+durationTime+SpecialColor.RESET);

    }

    public static void main(String[] args) {
        ifElseNanoTime();
        switchCaseNanoTime();
    }
}

