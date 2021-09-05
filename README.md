# Project name: Store Management System
## Description:
Store Management System is a System provide customers and staff members with services 
Like adding product or delete or update products for staff, on the other hand customers can see products and customers

The System provide  (https://hibernate.org) databas can store Customers and products side by side.
The System provide security for the for each users with user name and password.

Store Management System is a System that have multiple users ADMIN, ADMIN_TRAINEE, CUSTOMER
The System provide each user with specific Permission.
(https://github.com/Hamzeh-soft/Store_Management_SpringBoot/tree/master/src/main/java/com/hamzeh/cms/config)


Store Management System have multiple dependencies like:
#### Adding WEB Dependency 
It is used for building the web application, including RESTful applications using Spring MVC. It uses Tomcat as the default embedded container.
```
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```
#### Security Dependency
It is used for Spring Security.
```
  <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```
#### JPA Dependency
It is used for Spring Data JPA with Hibernate.
```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
```
#### com.google.guava
Guava is a set of core Java libraries from Google that includes new collection types (such as multimap and multiset), immutable collections, a graph library, and utilities for concurrency, I/O, hashing, caching, primitives, strings, and more! It is widely used on most Java projects within Google, and widely used by many other companies as well.
```
 <dependency>
            <groupId>com.google.guava</groupId>
            <artifactId>guava</artifactId>
            <version>28.2-jre</version>
            <type>jar</type>
        </dependency>
```

