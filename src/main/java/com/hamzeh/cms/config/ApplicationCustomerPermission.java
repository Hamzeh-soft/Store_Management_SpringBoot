/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.config;

/**
 *
 * @author User
 */
public enum ApplicationCustomerPermission {
    CUSTOMER_READ("customer:read"),
    PRODUCT_READ("PRODUCT:read"),
     PRODUCT_WRITE("PRODUCT:read");
    private final String permission;

    private ApplicationCustomerPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
    
}
