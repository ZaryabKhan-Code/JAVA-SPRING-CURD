package com.example.test.controller;


import com.example.test.model.Customer;
import com.example.test.model.Product;
import com.example.test.service.CustomerService;
import com.example.test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/Customer")
    public String customer(Model model){
        model.addAttribute("product_name",customerService.getAllCustomer());
        return "customer";
    }


    @GetMapping("/Menu")
    public String Menu(Model model){
        return "menu";
    }
    @GetMapping("/")
    public String admin(Model model){
        return "adminpage";
    }

    @PostMapping("/admin")
    public String send(){
        return "redirect:/Menu";
    }

    @GetMapping("/newCustomer")
    public String newProduct(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "new_customer";
    }
    @PostMapping("/save_newCustomer")
    public String saveProduct(@ModelAttribute("customer") Customer customer){
        customerService.saveProduct(customer);
        return "redirect:/Customer";
    }
    @GetMapping("/editCustomer/{id}")
    public String editProduct(@PathVariable(value = "id") long id, Model model){
        Customer product = customerService.getProductById(id);
        model.addAttribute("product_add",product);
        return "update_customer";
    }
    @GetMapping("/deleteCustomer/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id, Model model){
        this.customerService.deleteProduct(id);
        return "redirect:/Customer";
    }

}
