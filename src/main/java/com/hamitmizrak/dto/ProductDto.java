package com.hamitmizrak.dto;

import com.hamitmizrak.utilty.Loggable;
import lombok.*;

import java.io.Serializable;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@Builder

// ===> 4 Product Sınıfı
// Ürün bilgilerinği içeren nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.
@Loggable("Product") // Log Kategorisiyle belirtildi
public class ProductDto extends BaseDto implements  Serializable {

    // Field
    private String name;
    private Double price;

    // Parametreli Constructor
    public ProductDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    // toString
    @Override
    public String toString() {
        return "_04_ProductDto{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", creatAt=" + creatAt +
                '}';
    }

    // Method
    @Override
    public String getLogInfo() {
        return name + " - " + price + " TL";
    }

    // Getter And Setter
} // end
