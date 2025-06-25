package com.hamitmizrak._03_week;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class _08_3_Generics <T> {

    private String name;
    private T price;


    // METHOD
    public  <T> void printData(T number){
        System.out.println(number);
    }

    // GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }


    // PSVM
    public static void main(String[] args) {
        _08_3_Generics  generics = new _08_3_Generics();
        generics.setName("Hamit");
        generics.setPrice("44.0 TL");
        System.out.println(generics.getName()+" "+generics.getPrice());

        generics.setPrice(44.0);
        System.out.println(generics.getName()+" "+generics.getPrice());

        generics.printData(55);
        generics.printData("55");
        generics.printData(55.44);

    }
}

