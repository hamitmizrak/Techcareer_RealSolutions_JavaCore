package com.hamitmizrak._05_week.project;

import lombok.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

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
//public class _07_Order extends _03_BaseDto implements _02_IFile, _06_IOrder { // 1.YOL
//public class _08_Order extends _03_BaseDto implements _06_IOrder {     // 2.YOL
public class _08_Order extends _03_BaseDto implements _07_IAllMethod {  // 3.YOL

    // Field
    private _04_CustomerDto customerDto;
    private List<_05_ProductDto> productDtoList;

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

    // Order
    @Override
    public double getSeriTotalAmount() {
        return 0;
    }

    @Override
    public double getParallelTotalAmount() {
        return 0;
    }

    @Override
    public List<String> getProductNameList() {
        return List.of();
    }

    @Override
    public List<_05_ProductDto> getProductsMoreThan() {
        return List.of();
    }

    @Override
    public OptionalDouble getAveragePrice() {
        return OptionalDouble.empty();
    }

    @Override
    public Optional<_05_ProductDto> getMostExpensiveProduct() {
        return Optional.empty();
    }

    @Override
    public boolean isSameProductsName(String name) {
        return false;
    }

    @Override
    public boolean containsPRoductNamed(String name) {
        return false;
    }

    @Override
    public boolean nonIsPriveFree() {
        return false;
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
} // end

