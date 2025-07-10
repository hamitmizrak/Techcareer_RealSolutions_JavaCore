package com.hamitmizrak.controller.impl;

import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.dto.ProductDto;
import com.hamitmizrak.services.ProductService;
import com.hamitmizrak.utilty.SpecialColor;

import java.util.List;

public class ProductControllerImpl {

    // Field
    private final ProductService productService = new ProductService();

    // SAVE
    public void productControllerSave(ProductDto productDto, CustomerDto customerDto) {
        productService.productServiceSave(productDto,customerDto);
        System.out.println(SpecialColor.BLUE+" Ürün Başarıyla Eklendi "+SpecialColor.RESET);
    }

    // FIND ALL
    public void productControllerFindAll() {
        List<ProductDto> productDtoList = productService.productServiceFindAll();
        System.out.println(SpecialColor.YELLOW+ "Tüm Müşteriler"+SpecialColor.RESET+"\n");
        for ( ProductDto productDto : productDtoList){
            System.out.println(productDto);
        }
    }

} // end CustomerController
