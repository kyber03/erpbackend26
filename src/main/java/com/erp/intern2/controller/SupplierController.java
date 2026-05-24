package com.erp.intern2.controller;

import com.erp.intern2.model.Customers;
import com.erp.intern2.model.Suppliers;
import com.erp.intern2.service.CustomerService;
import com.erp.intern2.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
@Tag(name = "Supplier APIs", description = "Operations related to Suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @GetMapping("/all")
    @Operation(summary = "Get all Suppliers")
    @PreAuthorize("hasAnyRole('ADMIN','PURCHASE')")
    public ResponseEntity<List<Suppliers>> getAllSuppliers(){
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ADMIN','PURCHASE')")
    @Operation(summary = "Adding new Supplier")
    public ResponseEntity<String> addCustomer(@RequestBody Suppliers newSupplier){
        supplierService.addSupplier(newSupplier);
        return new ResponseEntity<>("Supplier added successfully", HttpStatus.OK);
    }
}
