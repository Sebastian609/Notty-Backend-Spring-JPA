package com.notty.Notty.Presentation;


import com.notty.Notty.Aplication.UserService;
import com.notty.Notty.Aplication.dto.LoginDto;
import com.notty.Notty.Infraestructure.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {

        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }



    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDto loginDto ){
        String email = loginDto.getMail();
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getMail(),loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());
        String jwt = this.jwtUtil.create(email);
        String id = String.valueOf(userService.getIdByEmail(email));
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,jwt,id).build();
    }
}