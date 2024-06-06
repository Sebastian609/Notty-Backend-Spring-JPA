package com.notty.Notty.Infraestructure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static String SECRET_KEY = "n0tty-gr0ups";

    private static Algorithm ALGORITHM =Algorithm.HMAC256(SECRET_KEY);

    public boolean isValid(String jwt){
    try {
        JWT.require(ALGORITHM)
                .build()
                .verify(jwt);
        return true;
    }catch (JWTVerificationException e){
        return false;
    }
    }
    public String create(String mail){

     return JWT.create()
             .withSubject(mail)
             .withIssuer("notty-groups")
             .withIssuedAt(new Date())
             .withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
             .sign(ALGORITHM);
 }

 public String getUser(String jwt) {

     return JWT.require(ALGORITHM)
             .build()
             .verify(jwt)
             .getSubject();
 }


}
