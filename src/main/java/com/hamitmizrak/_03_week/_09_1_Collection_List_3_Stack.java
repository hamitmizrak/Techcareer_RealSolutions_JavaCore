package com.hamitmizrak._03_week;

import java.util.Stack;

public class _09_1_Collection_List_3_Stack {

    private static void stackData() {
        Stack<String> stack = new Stack<>();
        stack.add("1.data");
        stack.add("2.data");
        stack.add("3.data");
        stack.add("4.data");
        stack.add("5.data");

        System.out.println("Eleman Sayısı: " + stack.size());
        System.out.println("ilk data: " + stack.get(0));

        System.out.println("son data: " + stack.get(stack.size() - 1));
        System.out.println("son data: " + stack.peek());

        System.out.println("** ITERATIVE FOR **********************");
        // ITERATIVE FOR
        for (int i = 0; i <stack.size() ; i++) {
            System.out.print(stack.get(i)+" ");
        }

        Object data = stack.pop(); // En sondan bir eleman çıkar
        System.out.println("\nÇıkartılan eleman: " + data);

        System.out.println("** FOREACH **********************");
        // FOR EACH
        for (Object temp:stack) {
            System.out.print(temp+" ");
        }

        //////////////////////////////////////////////////////
        stack.remove(0);
        System.out.println("\n** STREAM FOR **********************");
        stack.stream().forEach(System.out::println);

        stack.clear();
        System.out.println("\n** STREAM FOR **********************");
        stack.stream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        stackData();
    }
}
