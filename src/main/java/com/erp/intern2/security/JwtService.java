package com.erp.intern2.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtService {

       public static final String SECRET = "oiasdoeiubeiub283ye273ye4hur47fg48c90wf3";

       public String generateToken(String username, String role){
           HashMap<String, Object> claims = new HashMap<>();
           claims.put("Role", role);

           return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60))
                   .addClaims(claims)
                   .signWith(getSignedKey())
                   .compact();


       }

       private Key getSignedKey(){
              return Keys.hmacShaKeyFor(SECRET.getBytes());
       }

       public Claims verifySignatureAndExtractAllClaims(String token){
           return Jwts.parserBuilder()
                   .setSigningKey(getSignedKey())
                   .build()
                   .parseClaimsJws(token)
                   .getBody();
       }

         public String extractUserName(String token){
           return verifySignatureAndExtractAllClaims(token).getSubject();
         }

    public Date getExpiration(String token){

           return verifySignatureAndExtractAllClaims(token).getExpiration();
    }


    public Boolean isTokenExpired(String token){
           return getExpiration(token).before(new Date());
         }
}
