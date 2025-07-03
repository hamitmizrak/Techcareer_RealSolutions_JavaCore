package com.hamitmizrak._05_week;

// interface public ve default Access Modifier(ERişim belirleyici olarak)
// keyword: implements
// istediğimiz kadar interface ekleyebiliriz.
public interface _05_9_Interfaces {
    void create();
    void list();
    void delete();
    void findById();
    void update();
}

// CLASS
class Deneme implements _05_9_Interfaces {

    @Override
    public void create() {
        System.out.println("Create");
    }

    @Override
    public void list() {
        System.out.println("List");
    }

    @Override
    public void delete() {
        System.out.println("Delete");
    }

    @Override
    public void findById() {
        System.out.println("Find By ID");
    }

    @Override
    public void update() {
        System.out.println("Update");
    }
}

//
class OtherClass implements _05_9_Interfaces {

    @Override
    public void create() {
        System.out.println("Merhabalar");
    }

    @Override
    public void list() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void findById() {

    }

    @Override
    public void update() {

    }
}

// Javascript
// Java
// Python
// Ts

