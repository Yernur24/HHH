package com.narxoz.kz.ssss.controller;
import com.narxoz.kz.ssss.model.Customer;
import com.narxoz.kz.ssss.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

import java.util.List;

@RestController
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customer")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
