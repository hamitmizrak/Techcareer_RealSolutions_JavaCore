package com.hamitmizrak._05_week.oop._4_abstractx;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

// LOMBOK
@Getter
@Setter
@ToString
public class Student extends Person {

    // Field
    private String number;

    // Parametresiz Construtor
    public Student() {
    }

    // Abstract Gövdesiz Metot
    @Override
    public void specialData() {
        System.out.println("Student: "+ UUID.randomUUID().toString());
    }

    // Parametreli Constructor
    public Student(int id, String name, String surname, String tcNumber, Date createdDate, String number) {
        super(id, name, surname, tcNumber, createdDate);
        this.number = number;
    }

    // METHOD
    // FULLNAME
    @Override
    public void fullName(){
        System.out.println(getId()+" "+id+" "+getName()+" "+getSurname());
    }

    // TC NUMBER VALIDATION
    @Override
    public boolean tcNumberValidation(Long tcNumber){
        System.out.println("Student tc number validation");
        if(tcNumber!=null){
            // Tc kimlik Algorithm
            return true;
        }
        return false;
    }

    @Override
    public boolean isGender(String gender) {
        if(gender.equals("erkek"))
            return true;
        return false;
    }
} // end Student
