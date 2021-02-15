/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.dao;

import com.hamzeh.cms.Model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{

    @Override
    public List<Product> findAll();
    
}
