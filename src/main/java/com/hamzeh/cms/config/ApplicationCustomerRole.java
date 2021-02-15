/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.config;
import com.google.common.collect.Sets;
import static com.hamzeh.cms.config.ApplicationCustomerPermission.*;
import java.util.Set;

/**
 *
 * @author User
 */
public enum ApplicationCustomerRole {
    CUSTOMER(Sets.newHashSet(PRODUCT_READ,CUSTOMER_READ)),
    ADMIN(Sets.newHashSet(PRODUCT_READ,CUSTOMER_READ,PRODUCT_WRITE)),
    ADMIN_TRAINEE(Sets.newHashSet(PRODUCT_READ,CUSTOMER_READ));
    private final Set<ApplicationCustomerPermission> permissions;//must be uniqe

    private ApplicationCustomerRole(Set<ApplicationCustomerPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationCustomerPermission> getPermissions() {
        return permissions;
    }
    
    
}
