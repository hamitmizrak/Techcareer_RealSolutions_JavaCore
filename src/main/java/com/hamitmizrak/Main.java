package com.hamitmizrak;

import com.hamitmizrak.controller.impl.CustomerControllerImpl;
import com.hamitmizrak.dto.CustomerDto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Injection
   private static CustomerControllerImpl customerControllerImpl;

    private static void customerAdd(){
        customerControllerImpl = new CustomerControllerImpl();
        CustomerDto customerDto1 = new CustomerDto("Hamit Mızrak","hamitmizrak@gmail.com");
        CustomerDto customerDto2 = new CustomerDto("Hamit Mızrak2","hamitmizrak2@gmail.com");

        customerControllerImpl.customerControllerSave(customerDto1);
        customerControllerImpl.customerControllerSave(customerDto2);

        // Tüm Müşterileri Listele
        customerControllerImpl.customerControllerFindAll();
    }

    public static void main(String[] args) {
        customerAdd();
    }
}