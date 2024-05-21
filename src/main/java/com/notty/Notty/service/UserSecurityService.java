package com.notty.Notty.service;

import com.notty.Notty.persistence.entity.RolEntity;
import com.notty.Notty.persistence.entity.UserEntity;
import com.notty.Notty.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserSecurityService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findById(Integer.parseInt(username))
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));


        String[] roles = userEntity.getRoles().stream().map(RolEntity::getName).toArray(String[]::new);

        return User.builder()
                .username(userEntity.getMail())
                .password(userEntity.getPassword())
                .roles(roles)
                .accountLocked(userEntity.getActiveUser())
                .build();
    }


}
