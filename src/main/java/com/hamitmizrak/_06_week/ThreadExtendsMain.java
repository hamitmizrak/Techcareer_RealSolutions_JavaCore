package com.hamitmizrak._06_week;

public class ThreadExtendsMain {

    public static void main(String[] args) throws InterruptedException {

        // Thread Instance
        ThreadExtends thread1=new ThreadExtends(1L,"java se");
        ThreadExtends thread2=new ThreadExtends(2L,"java me");
        ThreadExtends thread3=new ThreadExtends(3L,"java ee");

        // Start
        // join: üst Thread bitmeden diğer Threadler başlamasın
        System.out.println("getName "+thread1.getName());
        System.out.println("HashCode "+thread1.hashCode());
        System.out.println("thread1 isAlive "+thread1.isAlive());
        thread1.start();
        System.out.println("thread1 isAlive "+thread1.isAlive());
        thread1.join();
        System.out.println("thread1 isAlive "+thread1.isAlive());

        thread2.start();
        thread3.start();
        thread2.join();
        thread3.join();
    }
}
