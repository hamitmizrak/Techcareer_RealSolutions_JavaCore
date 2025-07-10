package com.hamitmizrak.dao.impl;

import com.hamitmizrak.dao.IFile;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.dto.ProductDto;
import com.hamitmizrak.utilty.FilePath;
import com.hamitmizrak.utilty.SpecialColor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IFile<ProductDto> {

    // File
    private String specialPath;

    // Constructor
    public ProductDao() {
        specialPath = FilePath.FILE_PATH.concat("product.txt");
    }

    // SAVE
    @Override
    public void save(ProductDto productDto) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(specialPath, true))) {
            bufferedWriter.write(productDto.getId() + "," + productDto.getName() + "," + productDto.getPrice());
            bufferedWriter.flush();// acilen kaydet
            bufferedWriter.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // FINDALL
    @Override
    public List<ProductDto> findAll() {
        // CustomerDto Listesi
        List<ProductDto> productDtoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(specialPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // 1.Boş Satırları atla
                if(line.trim().isEmpty())
                    continue;

                // 2. Split işlemleri sonrasında alan sayısını kontrol edelim
                //String[] fileArray =  line.split("[,\\s]+"); // hem virgül hem 1+ boşluk
                String[] fileArray =  line.split(","); // hem virgül hem 1+ boşluk
                if(fileArray.length!=3){
                    System.out.println(SpecialColor.RED+" Uyarı Hatalı Formatlı satır atlandı ==> "+SpecialColor.RESET+ line);
                    continue;
                }

                try {
                    // 3.Tip dönüşüm hataları varsa
                    long id = Long.parseLong(fileArray[0].trim());
                    String name = fileArray[1].trim();
                    double price =Double.valueOf(fileArray[2].trim());

                    // 4. Null veya boş değer kontrolü
                    if(name.isEmpty()){
                        System.out.println(SpecialColor.RED+" Eksik kullanıcı verisi==> "+SpecialColor.RESET+line);
                    }

                    // 5.ProductDto nesnesi oluşturmak
                    // Long id, String name, double price
                    ProductDto productDto = new ProductDto(name,price);
                    productDtoList.add(productDto);
                }catch (NumberFormatException numberFormatException){
                    numberFormatException.printStackTrace();
                    System.out.println("Uyarı sayıya çevrilemeyen veri atlandı=> "+ line);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(SpecialColor.RED+" Dosya Okuma başarısız");
        }
        return productDtoList;
    }
}
