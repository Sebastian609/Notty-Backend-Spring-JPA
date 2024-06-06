package com.notty.Notty.Aplication;

import com.notty.Notty.Domain.UserEntity;
import com.notty.Notty.DataAccess.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int getIdByEmail(String email){
        return  this.userRepository.findByMail(email).getIdUser();
    }






}

