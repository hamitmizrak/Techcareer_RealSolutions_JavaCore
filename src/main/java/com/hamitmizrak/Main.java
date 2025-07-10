package com.hamitmizrak;

import com.hamitmizrak.controller.impl.CustomerController;
import com.hamitmizrak.dto.CustomerDto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Injection
   private static CustomerController customerController;

    private static void customerAdd(){
        customerController= new CustomerController();
        CustomerDto customerDto1 = new CustomerDto(Long.valueOf(1L), "Hamit Mızrak","hamitmizrak@gmail.com");
        CustomerDto customerDto2 = new CustomerDto(Long.valueOf(2L), "Hamit Mızrak2","hamitmizrak2@gmail.com");

        customerController.customerControllerSave(customerDto1);
        customerController.customerControllerSave(customerDto2);

        // Tüm Müşterileri Listele
        customerController.customerControllerFindAll();
    }

    public static void main(String[] args) {
        customerAdd();
    }
}