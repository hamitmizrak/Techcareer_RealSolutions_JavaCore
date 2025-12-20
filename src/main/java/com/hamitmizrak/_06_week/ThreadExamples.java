package com.hamitmizrak._06_week;

// Thread Extends
public class ThreadExamples extends Thread{
    @Override
    public void run() {
        System.out.println("Thread Extends");
    }
}

// Thread Implements
class ThreadImplements implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread Implements");
    }
}

// Thread Implements
class ThreadMainImplements{
    public static void main(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Main Implements");
            }
        });
    }
}
