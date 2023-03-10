package com.example.test.service;
import com.example.test.model.Product;
import com.example.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        Product product = null;
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
        }else{
            throw new RuntimeException("Product Not Found For Id ::" +id);
        }
        return product;
    }

    @Override
    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }
}
