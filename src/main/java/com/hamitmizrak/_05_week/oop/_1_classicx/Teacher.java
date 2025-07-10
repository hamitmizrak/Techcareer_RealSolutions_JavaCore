package com.hamitmizrak._05_week.oop._1_classicx;

import lombok.*;

import java.util.Date;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    // Field
    private int id;
    private String name;
    private String surname;
    private String tcNumber;
    private String price;
    private Date createdDate;

    // METHOD
    public void fullName(){
        System.out.println(id+" "+name+" "+surname);
    }

    // TC NUMBER VALIDATION
    // TC NUMBER VALIDATION
    public boolean tcNumberValidation(Long tcNumber){
        System.out.println("Student tc number validation");
        if(tcNumber!=null){
            // Tc kimlik Algorithm
            return true;
        }
        return false;
    }

} // end Student
