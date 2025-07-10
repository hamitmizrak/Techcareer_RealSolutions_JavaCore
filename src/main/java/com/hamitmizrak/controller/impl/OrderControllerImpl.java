package com.hamitmizrak.controller.impl;

import com.hamitmizrak.dao.IAllMethod;
import com.hamitmizrak.dto.BaseDto;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.dto.ProductDto;
import com.hamitmizrak.utilty.Loggable;
import lombok.*;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

// LOMBOK
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// ==> 5. Order Class()
// Siparişi Temsil eder Müşteri ve Ürün Listesi içerir.

// @_01_Loggable anostasyonu ile işaretliyecektir.
@Loggable("Order") // Log Kategorisiyle belirtildi
//public class _07_Order extends _03_BaseDto implements _02_IFile, _06_IOrder { // 1.YOL
//public class _08_Order extends _03_BaseDto implements _06_IOrder {     // 2.YOL
public class OrderControllerImpl extends BaseDto implements IAllMethod {  // 3.YOL

    // Field
    private CustomerDto customerDto;
    private List<ProductDto> productDtoList;

    // ToString
    @Override
    public String toString() {
        return "Order of" +
                "müşteri adı=" + customerDto.getName() +
                ", toplam Tutar=" + getSeriTotalAmount() +
                '}';
    }

    // Method
    @Override
    public String getLogInfo() {
        return "Order[ Customer="+customerDto.getName()+" Total: "+getSeriTotalAmount()+" ]";
    }

    // Stream api, Lambda Expression, Method Referances
    // Order Method
    // 1 - Üründeki Toplam fiyat hesaplaması (Seri)
    @Override
    public double getSeriTotalAmount() {
        return productDtoList.stream().mapToDouble(ProductDto::getPrice).sum();
    }

    // 2 - Ürün nesnesindeki ==>  Toplam fiyat hesaplaması (Paralelleştirme)
    @Override
    public double getParallelTotalAmount() {
        return  productDtoList.parallelStream().mapToDouble(ProductDto::getPrice).sum();
    }

    // 3 - Ürün nesnesindeki ==>  Tüm ürünlerin adlarını liste olarak dönsün
    @Override
    public List<String> getProductNameList() {
        // 1.YOL Lambda Expression
        //return productDtoList.stream().map((temp)-> temp.getName()).collect(Collectors.toList());

        // 2.YOL Method Referances 100
        return productDtoList.stream().map(ProductDto::getName).collect(Collectors.toList());
    }

    // 4 - Ürün nesnesindeki ==>  Belirli fiyat üstü ürünleri Listelensin
    @Override
    public List<ProductDto> getProductsMoreThan(double price) {
        return productDtoList
                .stream()
                .filter((temp)->temp.getPrice()>price)
                .collect(Collectors.toList());
    }

    // 5 - Ürün nesnesindeki ==>  Ortalama ürün fiyatını hesapla
    @Override
    public OptionalDouble getAveragePrice() {
        return  productDtoList
                .stream()
                .mapToDouble(ProductDto::getPrice).average();
    }

    // 6- Ürün nesnesindeki ==>  En pahalı ürünü dönder
    @Override
    public Optional<ProductDto> getMostExpensiveProduct() {
        return Optional.empty();
    }

    // 7- Ürün nesnesindeki ==>   Tüm ürünlerimiz aynı isimle mi yazılmış
    @Override
    public boolean isSameProductsName(String name) {
        return productDtoList
                .stream()
                .allMatch(temp -> temp.getName().equalsIgnoreCase(name));
    }

    // 8- Ürün nesnesindeki ==>  En az bir ünüde belirli isimde mi?
    @Override
    public boolean containsProductNamed(String name) {
        return  productDtoList
                .stream()
                .anyMatch(temp -> temp.getName().equalsIgnoreCase(name));
    }
    // 9- Ürün nesnesindeki ==>  Bütün ürünlerden Ücretsiz ürün var mı ?
    @Override
    public boolean nonIsPriveFree() {
        return  productDtoList
                .stream()
                .noneMatch(temp -> temp.getPrice()==0.0);
    }


    // Fiel Method

    @Override
    public void save(Object o) {

    }

    @Override
    public List<CustomerDto>  findAll() {

        return null;
    }
} // end

