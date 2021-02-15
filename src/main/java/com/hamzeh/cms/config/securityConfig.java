/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamzeh.cms.config;


import static com.hamzeh.cms.config.ApplicationCustomerPermission.PRODUCT_WRITE;
import static com.hamzeh.cms.config.ApplicationCustomerRole.ADMIN;
import static com.hamzeh.cms.config.ApplicationCustomerRole.ADMIN_TRAINEE;
import static com.hamzeh.cms.config.ApplicationCustomerRole.CUSTOMER;
import static java.lang.System.out;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
   /* @Autowired
    ForbiddenExcption forbiddenExcption;*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /* http
                .csrf().disable()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();*/
        http
                .csrf().disable().authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")
                .permitAll()
                //.antMatchers("/Customers/*").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.GET, "/Customers").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name(), CUSTOMER.name())
                .antMatchers(HttpMethod.PUT, "/Customers").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .antMatchers(HttpMethod.POST, "/Customers").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .antMatchers(HttpMethod.DELETE, "/Customers").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .antMatchers(HttpMethod.DELETE, "/management/Customers/*").hasAuthority(PRODUCT_WRITE.name())
                .antMatchers(HttpMethod.POST, "/management/Customers/*").hasRole(ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/management/Customers/*").hasAuthority(PRODUCT_WRITE.name())
                .antMatchers(HttpMethod.GET, "/management/Customers/*").hasAnyRole(ADMIN.name(), ADMIN_TRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}hamzeh")
                .roles("USER");
    }*/
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails hamzeh = User.builder()
                .username("hamzeh")
                .password(passwordEncoder.encode("hamzeh"))
                .roles(ADMIN.name())
                .build();
        UserDetails osama = User.builder()
                .username("osama")
                .password(passwordEncoder.encode("osama"))
                .roles(ADMIN_TRAINEE.name())
                .build();

        UserDetails Ahmad = User.builder()
                .username("Ahmad")
                .password(passwordEncoder.encode("password"))
                .roles(CUSTOMER.name())
                .build();

        return new InMemoryUserDetailsManager(
                hamzeh, osama, Ahmad
        );
    }

}
