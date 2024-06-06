package com.notty.Notty.Presentation;

import com.notty.Notty.Domain.UserEntity;
import com.notty.Notty.Aplication.UserService;
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
    @GetMapping("/login")
    public boolean login() {
        return true;
    }


    

}
