package com.notty.Notty.Aplication;

import com.notty.Notty.Domain.RolEntity;
import com.notty.Notty.Domain.UserEntity;
import com.notty.Notty.DataAccess.UserRepository;
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
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        UserEntity userEntity = this.userRepository.findByMail(mail);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with email: " + mail);
        }

        System.out.println(userEntity.getPassword()); // This should be removed in production

        String[] roles = userEntity.getRoles().stream()
                .map(RolEntity::getName)
                .toArray(String[]::new);

        return User.builder()
                .username(userEntity.getMail())
                .password(userEntity.getPassword())
                .roles(roles) // Using extracted roles
                .accountLocked(false)
                .disabled(false)
                .build();
    }
}
