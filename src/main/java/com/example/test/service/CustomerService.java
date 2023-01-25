package com.example.test.service;

import com.example.test.model.Customer;
import com.example.test.model.Product;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer();
    void saveProduct(Customer customer);
    Customer getProductById(long id);
    void deleteProduct(long id);
}
