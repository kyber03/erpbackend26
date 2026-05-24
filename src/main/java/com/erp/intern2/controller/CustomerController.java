package com.erp.intern2.controller;

import com.erp.intern2.model.Customers;
import com.erp.intern2.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer APIs", description = "Operations related to Customers")
public class CustomerController {

    private final CustomerService custService;

    public CustomerController(CustomerService custService){
        this.custService = custService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all Customers")
    @PreAuthorize("hasAnyRole('ADMIN','SALES_EXECUTIVE')")
    public ResponseEntity<List<Customers>> getAllCustomers(){
        return ResponseEntity.ok(custService.getAllCustomers());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','SALES_EXECUTIVE')")
    @Operation(summary = "Adding new Customer")
    public ResponseEntity<String> addCustomer(@RequestBody Customers newCustomer){
        custService.addCustomer(newCustomer);
        return new ResponseEntity<>("Customer added successfully", HttpStatus.OK);
    }
}
