package com.hamitmizrak._05_week.project;

// ===> 3 Customer Sınıfı
// Bir müşteri nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.

import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@_01_Loggable("Customer") // Log Kategorisiyle belirtildi
public class _03_CustomerDto extends _02_BaseDto {

    // Field
    private String name;
    private String email;

    // Parametreli Constructor

    // toString
    @Override
    public String toString() {
        return "_03_CustomerDto { " +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", creatAt=" + creatAt +
                '}';
    }

    // Method
    @Override
    public String getLogInfo() {
        return name+" "+email+ " ";
    }

    // Getter And Setter
} // end
