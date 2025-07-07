package com.hamitmizrak._05_week.oop._3_inheritancex;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Getter
@Setter
@ToString
public class Student extends Person implements IPerson, Serializable {

    // Field
    private String number;

    // Parametresiz Construtor
    public Student() {
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
        System.out.println(id+" "+name+" "+surname);
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
