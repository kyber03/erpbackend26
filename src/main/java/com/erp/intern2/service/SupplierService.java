package com.erp.intern2.service;


import com.erp.intern2.model.Customers;
import com.erp.intern2.model.Suppliers;
import com.erp.intern2.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepo suppliers;

    public List<Suppliers> getAllSuppliers(){
        return suppliers.findAll();
    }

    public void addSupplier(Suppliers newSupplier){
        suppliers.save(newSupplier);
        System.out.println("Customer added successfully");
    }
}
