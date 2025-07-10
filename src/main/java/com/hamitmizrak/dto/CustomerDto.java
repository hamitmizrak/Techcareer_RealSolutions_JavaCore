package com.hamitmizrak.dto;

// ===> 3 Customer Sınıfı
// Bir müşteri nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.

import com.hamitmizrak.utilty.Loggable;
import com.hamitmizrak.dao.IFile;
import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Loggable("Customer") // Log Kategorisiyle belirtildi
public class CustomerDto extends BaseDto implements IFile {

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

    // FILES
    @Override
    public void createFile() {

    }

    @Override
    public void writeFile() {

    }

    @Override
    public void readFromFile() {

    }

    // Getter And Setter
} // end
