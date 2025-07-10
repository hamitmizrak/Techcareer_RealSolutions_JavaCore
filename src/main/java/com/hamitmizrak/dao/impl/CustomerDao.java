package com.hamitmizrak.dao.impl;

import com.hamitmizrak.dao.IFile;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.mysql.IDbConnectionInterface;
import com.hamitmizrak.utilty.FilePath;
import com.hamitmizrak.utilty.SpecialColor;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IFile<CustomerDto>, IDbConnectionInterface<CustomerDto> {

    // File
    private String specialPath;

    // Database

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

            // Database Save
            create(customerDto);
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
                    System.out.println("Uyarı sayıya çevrilemeyen veri atlandı=> "+ line);
                }

                // Database List
                System.out.println("===================================");
                list();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println(SpecialColor.RED+" Dosya Okuma başarısız");
        }
        return customerDtoList;
    }

    /*  -- Select
  select *  from customer;

  -- Insert
  insert into customer(name,email) values("isim","hamitmizrak"); */
    /// //////////////////////////////////////////////////////////////////////////////
    // DATABASE
    @Override
    public void create(CustomerDto customerDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "insert into customer(name,email) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerDto.getName());
            preparedStatement.setString(2, customerDto.getEmail());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Customer Ekleme Başarılı");
            } else {
                System.out.println("Customer Ekleme yapılmadı .....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(CustomerDto customerDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "update  customer set name=?,email=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerDto.getName());
            preparedStatement.setString(2, customerDto.getEmail());
            preparedStatement.setLong(3, customerDto.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Güncelleme Başarılı");
            } else {
                System.out.println("Güncelleme yapılmadı .....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(CustomerDto customerDto) {
        try (Connection connection = getInterfaceConnection()) {
            String sql = "delete from  customer  where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, customerDto.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Silme Başarılı");
            } else {
                System.out.println("Silme yapılmadı .....");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<CustomerDto> list() {
        ArrayList<CustomerDto> customerDtoArrayList = new ArrayList<CustomerDto>();
        CustomerDto customerDto;
        try (Connection connection = getInterfaceConnection()) {
            String sql = "select * from  customer";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerDto = new CustomerDto();
                customerDto.setId(resultSet.getLong("id"));
                customerDto.setName(resultSet.getString("name"));
                customerDto.setEmail(resultSet.getString("email"));
                customerDtoArrayList.add(customerDto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerDtoArrayList;
    }
}
