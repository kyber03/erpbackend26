# ERP Backend System

## Overview

This project is a backend ERP (Enterprise Resource Planning) system developed using Spring Boot.
The application provides REST APIs for managing Products, Customers, and Suppliers with JWT Authentication and Role-Based Access Control.

The APIs were tested successfully using Postman.

---

# Tech Stack

* Java 21
* Spring Boot 3
* Spring Security
* JWT Authentication
* Spring Data JPA
* PostgreSQL
* Maven
* Swagger / OpenAPI
* Postman

---

# Features

## Authentication & Security

* JWT Token Authentication
* Spring Security Integration
* Role-Based Authorization using `@PreAuthorize`
* BCrypt Password Encryption

### Supported Roles

* ADMIN
* SALES_EXECUTIVE
* PURCHASE
* INVENTORY
* ACCOUNTANT

---

# Modules Implemented

## Product Management

* Add Product
* Update Product
* Delete Product
* View All Products

## Customer Management

* Add Customer
* View All Customers

## Supplier Management

* Add Supplier
* View All Suppliers

---

# Project Structure

```text id="n9z3e0"
src/main/java
 └── com.erp.intern2
      ├── controller
      ├── service
      ├── repository
      ├── model
      ├── security
      └── config
```

---

# API Testing

All APIs were tested successfully using Postman with Bearer Token Authentication.

Example Header:

```text id="x10jv7"
Authorization: Bearer <your_jwt_token>
```

---

# Database

Database used: PostgreSQL

Example entities:

* Products
* Customers
* Suppliers
* Employees

---

# Swagger Documentation

Swagger UI integrated for API documentation.

Example URL:

```text id="4l8t4q"
http://localhost:8082/swagger-ui/index.html
```

---

# Future Enhancements

* Sales Order Module
* Purchase Order Module
* Inventory Tracking
* Invoice Generation
* Dashboard & Reports
* Frontend Integration (React)

---

# Author

Developed by Ubaid

```
```
