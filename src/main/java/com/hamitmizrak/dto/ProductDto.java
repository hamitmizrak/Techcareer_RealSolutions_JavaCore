package com.hamitmizrak.dto;

import com.hamitmizrak.utilty.Loggable;
import com.hamitmizrak.dao.IFile;
import lombok.*;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// ===> 4 Product Sınıfı
// Ürün bilgilerinği içeren nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.
@Loggable("Product") // Log Kategorisiyle belirtildi
public class ProductDto extends BaseDto implements IFile, Serializable {

    // Field
    private String name;
    private Double price;

    // Parametreli Constructor

    // toString
    @Override
    public String toString() {
        return "_04_ProductDto{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", creatAt=" + creatAt +
                ", id=" + id +
                '}';
    }

    // Method
    @Override
    public String getLogInfo() {
        return name + " - " + price + " TL";
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
