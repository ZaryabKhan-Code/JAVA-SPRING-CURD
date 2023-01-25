package com.example.test.service;

import com.example.test.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(long id);
    void deleteProduct(long id);
}
