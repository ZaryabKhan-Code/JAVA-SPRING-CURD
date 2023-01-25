package com.example.test.service;

import com.example.test.model.Customer;
import com.example.test.model.Product;
import com.example.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public void saveProduct(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer getProductById(long id) {
        Optional<Customer> optionalProduct = customerRepository.findById(id);
        Customer customer = null;
        if(optionalProduct.isPresent()){
            customer = optionalProduct.get();
        }else{
            throw new RuntimeException("Customer Not Found For Id ::" +id);
        }
        return customer;
    }

    @Override
    public void deleteProduct(long id) {
        this.customerRepository.deleteById(id);
    }
}
