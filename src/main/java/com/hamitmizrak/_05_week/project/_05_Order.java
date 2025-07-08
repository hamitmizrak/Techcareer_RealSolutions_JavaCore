package com.hamitmizrak._05_week.project;

import lombok.*;
import java.util.List;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// ==> 5. Order Class()
// Siparişi Temsil eder Müşteri ve Ürün Listesi içerir.

// @_01_Loggable anostasyonu ile işaretliyecektir.
@_01_Loggable("Order") // Log Kategorisiyle belirtildi
public class _05_Order extends _02_BaseDto {

    // Field
    private _03_CustomerDto customerDto;
    private List<_04_ProductDto> productDtoList;

    // ToString
    @Override
    public String toString() {
        return "Order of" +
                "müşteri adı=" + customerDto.getName() +
                ", toplam Tutar=" + getTotalAmount() +
                '}';
    }

    // Method
    @Override
    public String getLogInfo() {
        return "Order[ Customer="+customerDto.getName()+" Total: "+getTotalAmount()+" ]";
    }

    // Toplam Tutar
    private double getTotalAmount() {
        return 0.0;
    }

} // end

