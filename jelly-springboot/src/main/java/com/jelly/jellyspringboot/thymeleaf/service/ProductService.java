package com.jelly.jellyspringboot.thymeleaf.service;

import com.jelly.jellyspringboot.thymeleaf.entity.Product;
import com.jelly.jellyspringboot.thymeleaf.repository.ProductRepository;

import java.util.List;

public class ProductService {


    ProductRepository productRepository=ProductRepository.getInstance();
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public  Product findById(Integer id){
        return  productRepository.findById(id);
    }
}
