package com.notty.Notty.web.controller;

import com.notty.Notty.persistence.entity.UserEntity;
import com.notty.Notty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getall(){
        return ResponseEntity.ok(this.userService.getAll());
    }
    @GetMapping("/{idUser}")
    public ResponseEntity<UserEntity> get(@PathVariable int idUser){
        return ResponseEntity.ok(this.userService.get(idUser) );
    }
    @PostMapping
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user){
        if(user.getIdUser() == null || !this.userService.exists(user.getIdUser())){
            return ResponseEntity.ok(this.userService.save(user) );
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity user){
        if(user.getIdUser() != null && this.userService.exists(user.getIdUser())){
            return ResponseEntity.ok(this.userService.save(user) );
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("login/{mail}/{password}")
    public ResponseEntity<UserEntity> login(@PathVariable String mail,String password){
        return ResponseEntity.ok(this.userService.login(mail,password));
    }
    

}
