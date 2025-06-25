package com.hamitmizrak._03_week;

// POJO : Plain Old Java Object
// POJO : Constructor olabilir veya olmayabilir
// Access Modifier(Erişim belirleyiciler) : public, private, protected, - gelebilir

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// LOMBOK
// @Data
@Getter
@Setter
public class _07_1_POJO_3_Class {

    // Field
    // @Getter @Setter
    private String name;
    public String surname;
    public int number;


    // PSVM
    public static void main(String[] args) {
        _07_1_POJO_3_Class aClass = new _07_1_POJO_3_Class();
    }
}
