/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.services;

import com.google.common.base.Optional;
import com.hamzeh.cms.Exception.NotFoundException;
import com.hamzeh.cms.Model.Product;
import com.hamzeh.cms.dao.ProductDao;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class ProductServices {

    @Autowired
    private ProductDao productDao;

    private Function<Integer, Product> productExiste = (id) -> {
        java.util.Optional<Product> productExiste = productDao.findById(id);
        if (!productExiste.isPresent()) {
            throw new NotFoundException("Product Does Not Exsits");
        }
        return productExiste.get();

    };

    public Product addProduct(Product product) {
        //productDao.findById(1).get(); get id from database
        return productDao.save(product);
    }

    public List<Product> getAllProduct() {
        return productDao.findAll();
    }

    public Product getProduct(int id) {

        return productExiste.apply(id);
    }

    public void deleteProduct(int id) {
        productDao.deleteById(productExiste.apply(id).getId());
    }

    public Product updateProdcut(int id, Product product) {
        product.setId(id);
        return productDao.save(product);
    }

    public List<Product> sortByPrice() {
        return productDao.findAll()
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }
}
