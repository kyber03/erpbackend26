package com.erp.intern2.repository;

import com.erp.intern2.model.Employee;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    Optional<Employee> findByUsername(String username);

    Optional<Employee> findByEmail(@Email String email);
}
