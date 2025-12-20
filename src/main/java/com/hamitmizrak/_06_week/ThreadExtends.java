package com.hamitmizrak._06_week;

// Thread Extends(Kalıtım)
public class ThreadExtends  extends Thread{
   // Thread Variable
    private Long threadID;
    private String threadNameData;

    // Thread Constructur(Parametreli)
    public ThreadExtends(Long threadID,String threadNameData) {
        this.threadNameData = threadNameData;
        this.threadID = threadID;
    }

    // Thread Run
    @Override
    public void run() {
        System.out.println("Thread Extends");
        for (int i = 1; i <=9 ; i++) {
            System.out.println("thread"+this.threadID+"="+i+" "+ this.threadNameData);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    } //thread run
} //end ThreadExtends
