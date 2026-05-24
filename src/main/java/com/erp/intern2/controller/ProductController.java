package com.erp.intern2.controller;

import com.erp.intern2.model.Product;
import com.erp.intern2.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product APIs", description = "Operations related to Products")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService){

        this.productService = productService;
    }

    @Operation(summary = "Get all products")
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN','SALES_EXECUTIVE','PURCHASE','INVENTORY','ACCOUNTANT')")
    public ResponseEntity<List<Product>> getAllProducts(){

        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Adding new product")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
          productService.addProduct(product);
          return new ResponseEntity<>("Product added successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','INVENTORY')")
    public ResponseEntity<String> editProduct(@RequestBody Product updated, @PathVariable Long id ){
         productService.editProduct(updated,id);
        return new ResponseEntity<>("Product Updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
