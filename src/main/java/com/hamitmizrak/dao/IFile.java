package com.hamitmizrak.dao;

import com.hamitmizrak.dto.CustomerDto;
import com.hamitmizrak.dto.ProductDto;

import java.util.List;

public interface IFile<T> {

    // FILE CREATE
    public void save(T t);

    // FILE READ
    public List<T> findAll();
}
