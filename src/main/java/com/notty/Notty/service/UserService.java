package com.notty.Notty.service;

import com.notty.Notty.persistence.entity.UserEntity;
import com.notty.Notty.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAll(){
        return this.userRepository.findAll();
    }
    public UserEntity get(int idUser){
        return this.userRepository.findById(idUser).orElse(null);
    }

    public UserEntity save(UserEntity userEntity){
        return this.userRepository.save(userEntity);
    }

    public boolean exists(int idUser) {
        return this.userRepository.existsById(idUser);
    }

    public UserEntity login(String mail, String password){
        return this.userRepository.findByMailAndPassword(mail,password);
    }




}

