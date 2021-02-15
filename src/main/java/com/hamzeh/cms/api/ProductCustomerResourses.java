/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.api;

import com.hamzeh.cms.Model.Product;
import com.hamzeh.cms.services.ProductServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping(value = "/Customers/Products")
public class ProductCustomerResourses {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public List<Product> getAllProduct() {
        return productServices.getAllProduct();
    }
    @GetMapping(value = "/sortByPrice")
    public List<Product> sortByPrice() {
        return productServices.sortByPrice();
    }

}
