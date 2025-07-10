package com.hamitmizrak.dto;

// ===> 3 Customer Sınıfı
// Bir müşteri nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.

import com.hamitmizrak.utilty.Loggable;
import com.hamitmizrak.dao.IFile;
import lombok.*;

import java.util.Date;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Loggable("Customer") // Log Kategorisiyle belirtildi
public class CustomerDto extends BaseDto {

    // Field
    private String name;
    private String email;

    // Parametreli Constructor
    public CustomerDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

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
        return name + " " + email + " ";
    }

} // end
