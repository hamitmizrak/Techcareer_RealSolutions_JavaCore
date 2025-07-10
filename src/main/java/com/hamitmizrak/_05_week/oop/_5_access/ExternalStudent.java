package com.hamitmizrak._05_week.oop._5_access;

import com.hamitmizrak._05_week.oop._4_abstractx.Person;

public class ExternalStudent extends Person {

    public void showInfo() {
        // Erişim mümkün, subclass + protected+  (extends Person)
        System.out.println(this.id + " " + this.name + " " + this.tcNumber);
    }

    @Override
    public void specialData() {
        System.out.println("Special Data");
    }
}
