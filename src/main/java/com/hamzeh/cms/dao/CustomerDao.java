/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.dao;

import com.hamzeh.cms.Model.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author User
 */
//Integr:for the id
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer>{
    @Override
    List<Customer> findAll();
   // Customer findById(int custId);
}
