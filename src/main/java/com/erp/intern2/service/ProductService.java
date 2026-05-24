package com.erp.intern2.service;


import com.erp.intern2.model.Product;
import com.erp.intern2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productrepo;

    public List<Product> getAllProducts(){
         return productrepo.findAll();
    }

    public void addProduct(Product newProduct){
        productrepo.save(newProduct);
    }

    public void editProduct(Product updatedProduct, Long id){
        Product existing = productrepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));

        existing.setCategory(updatedProduct.getCategory());
        existing.setName(updatedProduct.getName());
        existing.setSKU(updatedProduct.getSKU());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantities_avl(updatedProduct.getQuantities_avl());
        existing.setReorder_level(updatedProduct.getReorder_level());

        productrepo.save(existing);
    }

    public void deleteProduct(Long id){
        Product existing = productrepo.findById(id).orElseThrow(RuntimeException::new);
        productrepo.delete(existing);
    }



}
