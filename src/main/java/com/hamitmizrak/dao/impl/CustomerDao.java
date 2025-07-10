package com.hamitmizrak.dao.impl;

import com.hamitmizrak.dao.IFile;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.utilty.FilePath;
import com.hamitmizrak.utilty.SpecialColor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IFile<CustomerDto> {

    // File
    private String specialPath;

    // Constructor
    public CustomerDao() {
        specialPath = FilePath.FILE_PATH.concat("customer.txt");
    }

    // SAVE
    @Override
    public void save(CustomerDto customerDto) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(specialPath, true))) {
            bufferedWriter.write(customerDto.getId() + "," + customerDto.getName() + "," + customerDto.getEmail());
            bufferedWriter.flush();// acilen kaydet
            bufferedWriter.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // FINDALL
    @Override
    public List<CustomerDto> findAll() {
        // CustomerDto Listesi
        List<CustomerDto> customerDtoList = new ArrayList<>();
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
                    System.out.println(SpecialColor.RED+" Uyarı Hatalı Formatlı satır atlandı ==> "+ line);
                    continue;
                }

                try {
                    // 3.Tip dönüşüm hataları varsa
                    long id = Long.parseLong(fileArray[0].trim());
                    String name = fileArray[1].trim();
                    String email = fileArray[2].trim();

                    // 4. Null veya boş değer kontrolü
                    if(name.isEmpty() || email.isEmpty()){
                        System.out.println(SpecialColor.RED+" Eksik kullanıcı verisi==> "+line);
                    }

                    // 5.CustomerDto nesnesi oluşturmak
                    // Long id, String name, String email
                    CustomerDto customerDto = new CustomerDto(name,email);
                    customerDtoList.add(customerDto);
                }catch (NumberFormatException numberFormatException){
                    numberFormatException.printStackTrace();
                    System.out.println("Uyaroı sayıya çevrilemeyen veri atlandı=> "+ line);
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(SpecialColor.RED+" Dosya Okuma başarısız");
        }
        return customerDtoList;
    }
}
