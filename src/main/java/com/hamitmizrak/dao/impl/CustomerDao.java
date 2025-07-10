package com.hamitmizrak.dao.impl;

import com.hamitmizrak.dao.IFile;
import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.utilty.FilePath;

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
            bufferedWriter.write(customerDto.getId() + " " + customerDto.getName() + " " + customerDto.getEmail());
            bufferedWriter.flush();// acilen kaydet
            bufferedWriter.newLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // FINDALL
    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(specialPath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] fileArray = line.split(",");
                System.out.println(fileArray[0]);
                System.out.println(fileArray[1]);
                System.out.println(fileArray[2]);
                // Long id, String name, String email
                CustomerDto customerDto = new CustomerDto(Long.parseLong(fileArray[0]),fileArray[1],fileArray[2]);
                customerDtoList.add(customerDto);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return customerDtoList;
    }
}
