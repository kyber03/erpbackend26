package com.erp.intern2.repository;


import com.erp.intern2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustRepo extends JpaRepository<Customers,Long> {


}
