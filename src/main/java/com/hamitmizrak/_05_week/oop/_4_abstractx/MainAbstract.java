package com.hamitmizrak._05_week.oop._4_abstractx;

public class MainAbstract {

    public static void main(String[] args) {

        // PERSON-1
        //Person person = new Person(); // abstract new olamaz
        //Person person = new Teacher();  // polymorphism
        Person person = new Student();  // polymorphism
        person.setId(1);
        person.setName("person adı-1");
        person.setSurname("person soyadı-1");
        System.out.println(person);
        person.fullName();
        person.tcNumberValidation(123456L);
        boolean isPassStudent = person.tcNumberValidation(123456L);
        System.out.println(isPassStudent);
        System.out.println(person.isGender("erkek")? "erkek" :"bayan");
        person.specialData();
        System.out.println("\n=========================");


        // STUDENT-1
        Student student = new Student();
        student.setId(1);
        student.setName("öğrenci adı-1");
        student.setSurname("öğrenci soyadı-1");
        student.setNumber("öğrenci numarası-1");
        System.out.println(student);
        student.fullName();
        student.tcNumberValidation(123456L);
        System.out.println(student.isGender("erkek")? "erkek" :"bayan");
        student.specialData();
        System.out.println("\n=========================");

        // TEACHER-1
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("öğretmen adı-1");
        teacher.setSurname("öğretmen soyadı-1");
        teacher.setPrice("öğretmen maaş");
        System.out.println(teacher);
        teacher.fullName();
        boolean isPassTeacher = teacher.tcNumberValidation(123456L);
        System.out.println(student.isGender("bayan")? "erkek" :"bayan");
        teacher.specialData();
        System.out.println(isPassTeacher);

    }
}
