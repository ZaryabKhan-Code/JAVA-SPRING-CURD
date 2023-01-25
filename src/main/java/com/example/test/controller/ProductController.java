package com.example.test.controller;

import com.example.test.model.Product;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    // Display List Of Employees

    @GetMapping("/Products")
    public String index(Model model){
        model.addAttribute("product_name",productService.getAllProduct());
        return "index";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
    @PostMapping("/save_newProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/Products";
    }
    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable(value = "id") long id,Model model){
        Product product = productService.getProductById(id);
        model.addAttribute("product_add",product);
        return "update_product";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model){
        this.productService.deleteProduct(id);
        return "redirect:/Products";
    }
}
