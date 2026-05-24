package com.erp.intern2.security;

import com.erp.intern2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter jwtfilter;

     @Bean
     public SecurityFilterChain jwtAuth(HttpSecurity http) throws Exception {

          http
                 .csrf(csrf->csrf.disable())
                  .authorizeHttpRequests(auth->
                          auth.requestMatchers("/api/**", "/register","/authenticate")
                                  .permitAll()
                                  .anyRequest()
                                  .authenticated())
                  .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);


         return http.build();

     }
    @Bean
    public UserDetailsService userDetails(){
        return new EmployeeService();
    }

    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetails, PasswordEncoder psdEncoder){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetails);
        provider.setPasswordEncoder(psdEncoder);
        return new ProviderManager(provider);
    }

    @Bean
    public PasswordEncoder psdEncoder() {
        return new BCryptPasswordEncoder();
    }
}
