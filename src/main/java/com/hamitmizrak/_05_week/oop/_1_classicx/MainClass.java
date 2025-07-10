package com.hamitmizrak._05_week.oop._1_classicx;

public class MainClass {

    public static void main(String[] args) {
        // STUDENT-1
        Student student = new Student();
        student.setId(1);
        student.setName("öğrenci adı-1");
        student.setSurname("öğrenci soyadı-1");
        student.setNumber("öğrenci numarası-1");
        System.out.println(student);
        student.fullName();
        student.tcNumberValidation(123456L);
        boolean isPassStudent = student.tcNumberValidation(123456L);
        System.out.println(isPassStudent);
        System.out.println("\n=========================");

        // STUDENT-1
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("öğretmen adı-1");
        teacher.setSurname("öğretmen soyadı-1");
        teacher.setPrice("öğretmen maaş");
        System.out.println(teacher);
        teacher.fullName();
        boolean isPassTeacher = teacher.tcNumberValidation(123456L);
        System.out.println(isPassTeacher);

    }
}
