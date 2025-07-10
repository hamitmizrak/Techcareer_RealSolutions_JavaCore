package com.hamitmizrak._05_week.oop._2_interfacex;

import lombok.*;

import java.util.Date;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements IPerson {

    // Field
    private int id;
    private String name;
    private String surname;
    private String tcNumber;
    private String number;
    private Date createdDate;

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
