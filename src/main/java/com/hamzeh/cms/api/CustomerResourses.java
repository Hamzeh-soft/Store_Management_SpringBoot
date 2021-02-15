/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.api;

import com.hamzeh.cms.Model.Customer;
import com.hamzeh.cms.services.CustomerServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/Customers")
public class CustomerResourses {

    @Autowired
    private CustomerServices customerservics;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerservics.addCutomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCutomers() {
        return customerservics.getAllCutomer();
    }

    @GetMapping(value = "/{cutomerid}")
    public Customer getCutomer(@PathVariable("cutomerid") int custid) {
        return customerservics.getCutomer(custid);
    }

    @DeleteMapping(value = "/{cuntomdrdeleteid}")
    public void deleteCustomer(@PathVariable("cuntomdrdeleteid") int custid) {
        customerservics.deletCutomer(custid);
    }

    @GetMapping(value = "/sortByFirstnme")
    public List<Customer> sortCustomerByFirtsName() {
        return customerservics.sortByFirstName();
    }

    
    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@PathVariable("id") int custid, @RequestBody Customer customer) {
        return customerservics.updateCutomer(custid, customer);
    }
    

}
