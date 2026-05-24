package com.erp.intern2.repository;

import com.erp.intern2.model.Customers;
import com.erp.intern2.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepo extends JpaRepository<Suppliers,Long> {



}
