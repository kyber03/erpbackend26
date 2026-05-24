package com.erp.intern2.service;


import com.erp.intern2.model.Customers;
import com.erp.intern2.repository.CustRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustRepo customerRepo;

    public List<Customers> getAllCustomers(){
        return customerRepo.findAll();
    }

    public void addCustomer(Customers newCustomer){
        customerRepo.save(newCustomer);
          System.out.println("Customer added successfully");
    }

}
