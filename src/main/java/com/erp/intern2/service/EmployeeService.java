package com.erp.intern2.service;

import com.erp.intern2.model.Employee;
import com.erp.intern2.model.Role;
import com.erp.intern2.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private PasswordEncoder psdEncoder;

    @Autowired
    private EmployeeRepo employeerepo;

    public Employee getUserByUserName(String username){
        return employeerepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("USer not found"));
    }

    public void registerUser(Employee newEmployee) {

        Optional<Employee> existingUser = employeerepo.findByEmail(newEmployee.getEmail());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Email already exists");
        }


        newEmployee.setPassword(
                psdEncoder.encode(newEmployee.getPassword())
        );

        newEmployee.setRole(
                Role.valueOf(newEmployee.getRole().toString().toUpperCase())
        );

        employeerepo.save(newEmployee);


        // TODO: encode password later using BCrypt

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee emp = getUserByUserName(username);
        return User.builder()
                .username(emp.getUsername())
                .password(emp.getPassword())
                .authorities(new SimpleGrantedAuthority(emp.getRole().toString()))
                .build();

    }
}
