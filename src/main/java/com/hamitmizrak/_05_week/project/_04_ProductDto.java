package com.hamitmizrak._05_week.project;

import lombok.*;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// ===> 4 Product Sınıfı
// Ürün bilgilerinği içeren nesnesini temsil eder
// @_01_Loggable anostasyonu ile işaretliyecektir.
@_01_Loggable("Product") // Log Kategorisiyle belirtildi
public class _04_ProductDto extends _02_BaseDto {

    // Field
    private String name;
    private String price;

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

    // Getter And Setter
}
