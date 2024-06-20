package com.notty.Notty.Presentation;

import com.notty.Notty.Domain.DTO.UserDTO;
import com.notty.Notty.Domain.UserEntity;
import com.notty.Notty.Aplication.UserService;
import com.notty.Notty.Infraestructure.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getall(){
       List<UserDTO> userDTOs = this.userService.getAll().stream()
               .map(userMapper::UserToUserDTO)
               .collect(Collectors.toList());

       return ResponseEntity.ok(userDTOs);
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
