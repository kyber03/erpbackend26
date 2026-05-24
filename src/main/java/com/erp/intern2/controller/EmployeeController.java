package com.erp.intern2.controller;


import com.erp.intern2.model.Employee;
import com.erp.intern2.model.Role;
import com.erp.intern2.repository.EmployeeRepo;
import com.erp.intern2.security.AuthRequest;
import com.erp.intern2.security.JwtService;
import com.erp.intern2.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncoder encodedPsd;

    @Autowired
    private AuthenticationManager authmanager;

    @Autowired
    private JwtService jwtservice;

    @Operation(summary = "Register user link")
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Employee newUser){
        employeeService.registerUser(newUser);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }


    @PostMapping("/authenticate")
    public String generateWebToken(@RequestBody AuthRequest authrequest){
        Authentication authenticate = authmanager
                .authenticate
                        (new UsernamePasswordAuthenticationToken
                                (authrequest.getUsername(),authrequest.getPassword()));
        if(authenticate.isAuthenticated()){
            String role =  authenticate.getAuthorities()
                    .iterator()
                    .next()
                    .getAuthority()
                    .replace("ROLE_","");

            return jwtservice.generateToken(authrequest.getUsername(),role);
//
        }
        return "Invalid Credentials";

    }

}
