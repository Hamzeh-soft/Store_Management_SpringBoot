/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.services;

import com.hamzeh.cms.Exception.NotFoundException;
import com.hamzeh.cms.Model.Customer;
import com.hamzeh.cms.Model.Product;
import com.hamzeh.cms.dao.CustomerDao;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author User
 */
@Service
public class CustomerServices {

    @Autowired
    private CustomerDao cutomerdao;
    private Function<Integer, Customer> customerExiste = (id) -> {
        java.util.Optional<Customer> customerExiste = cutomerdao.findById(id);
        if (!customerExiste.isPresent()) {
            throw new NotFoundException("Customer Does Not Exsits");
        }
        return customerExiste.get();

    };

    public Customer addCutomer(Customer cutomer) {

        return cutomerdao.save(cutomer);
    }

    public List<Customer> getAllCutomer() {
        return cutomerdao.findAll();

    }

    public Customer getCutomer(int custid) {

        return customerExiste.apply(custid);
        

    }

    public Customer updateCutomer(int custid, Customer customer) {
        customer.setId(custid);

        return cutomerdao.save(customer);

    }

    public void deletCutomer(int custid) {
        cutomerdao.delete(customerExiste.apply(custid));
    }

    public List<Customer> sortByFirstName() {
        return cutomerdao.findAll()
                .stream()
                .sorted(Comparator.comparing(Customer::getFirstName))
                .collect(Collectors.toList());
    }

}
