package com.hamitmizrak._04_week;

import java.time.LocalDate;
import java.util.Objects;

public class _01_1_Classic_Class {

    // Field
    private String name;
    private String surname;
    private String email;
    private Long password;
    private LocalDate createdDate; // ===> final alanlar immutable olur
    private boolean isLogin = true;


    // Parametresiz Constructor
    public _01_1_Classic_Class() {
        createdDate = LocalDate.now(); //
    }

    // Parametreli Constructor (1)
    public _01_1_Classic_Class(String name) {
        this.name = name;
    }

    // Parametreli Constructor (2)
    public _01_1_Classic_Class(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Parametreli Constructor (3)
    public _01_1_Classic_Class(Long number, String surname, String name) {
        this.password = number;
        this.surname = surname;
        this.name = name;
    }

    public _01_1_Classic_Class(String name, String surname, Long number, boolean isLogin) {
        this.name = name;
        this.surname = surname;
        this.password = number;
        this.isLogin = isLogin;
    }

    public _01_1_Classic_Class(String name, String surname, String email, Long password, LocalDate createdDate, boolean isLogin) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.isLogin = isLogin;
    }

    // toString()
    @Override
    public String toString() {
        return "_01_1_Classic_Class{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password=" + password +
                ", createdDate=" + createdDate +
                ", isLogin=" + isLogin +
                '}';
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        _01_1_Classic_Class that = (_01_1_Classic_Class) o;
        return isLogin == that.isLogin && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(email, that.email) && Objects.equals(password, that.password) && Objects.equals(createdDate, that.createdDate);
    }

    // Hash Code
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password, createdDate, isLogin);
    }


    // Getter And Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isLogin(boolean b) {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // PSVM
    public static void main(String[] args) {
        _01_1_Classic_Class classicClass = new _01_1_Classic_Class();
        classicClass.setName("Hamit");
        classicClass.setSurname("Mızrak");
        classicClass.setEmail("hamitmizrak@gmail.com");
        classicClass.setPassword(444L);
        classicClass.isLogin(true);
        System.out.println(classicClass);
    }


}
