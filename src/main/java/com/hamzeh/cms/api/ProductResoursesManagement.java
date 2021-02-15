/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.api;

import com.google.common.base.Optional;
import com.hamzeh.cms.Model.Product;
import com.hamzeh.cms.dao.ProductDao;
import com.hamzeh.cms.services.ProductServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "management/Customers/Products")
public class ProductResoursesManagement {

    @Autowired
    private ProductServices productServices;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productServices.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return productServices.getAllProduct();
    }

    @GetMapping(value = "/{id}")
    public Product getProductByID(@PathVariable("id") int id) {
        return productServices.getProduct(id);
    }

    @PutMapping(value = "/{id}")
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return productServices.updateProdcut(id, product);
    }
    @GetMapping(value = "/sortByPrice")
    public List<Product> sortByPrice() {
        return productServices.sortByPrice();
    }
    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable("id") int id)
    {
        
        productServices.deleteProduct(id);
        
    }

}
