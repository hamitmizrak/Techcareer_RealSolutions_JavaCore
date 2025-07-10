package com.hamitmizrak;

import com.hamitmizrak.controller.impl.CustomerControllerImpl;
import com.hamitmizrak.controller.impl.ProductControllerImpl;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.dto.ProductDto;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Injection
    private static CustomerControllerImpl customerControllerImpl = new CustomerControllerImpl();


    // Customer Add
    private static void customerAdd() {
        // Müşteri Oluştur
        CustomerDto customerDto1 = new CustomerDto("Hamit Mızrak", "hamitmizrak@gmail.com");
        CustomerDto customerDto2 = new CustomerDto("Hamit Mızrak2", "hamitmizrak2@gmail.com");

        customerControllerImpl.customerControllerSave(customerDto1);
        customerControllerImpl.customerControllerSave(customerDto2);

        // Tüm Müşterileri Listele
        customerControllerImpl.customerControllerFindAll();
    }

    // Product- Customer (Composition)
    private static void customerOnProductAdd() {
        // Müşteri Oluştur
        CustomerDto customerDto1 = new CustomerDto("Hamit Mızrak", "hamitmizrak@gmail.com");
        customerControllerImpl.customerControllerSave(customerDto1);

        // Tüm Müşterileri Listele
        customerControllerImpl.customerControllerFindAll();
        System.out.println("\n=============================================");


        // Ürünleri oluştur
        ProductDto laptopProduct = new ProductDto("Laptop",12.0);
        ProductDto klavyeProduct = new ProductDto("Klavye",8.0);

        // Controller ÜZerinden ilişkilendir
        ProductControllerImpl productControllerImpl = new ProductControllerImpl();
        productControllerImpl.productControllerSave(laptopProduct,customerDto1);
        productControllerImpl.productControllerSave(klavyeProduct,customerDto1);

        // Müşteri bilgisyle birlikte ürünleri yazdır
        System.out.println(customerDto1);

        // Tüm Ürünleri Listele
        productControllerImpl.productControllerFindAll();

    }


    public static void main(String[] args) {
        //customerAdd();
        customerOnProductAdd();
    }
}