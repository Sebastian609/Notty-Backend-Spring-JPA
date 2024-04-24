package com.notty.Notty.persistence.repository;

import com.notty.Notty.persistence.entity.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity,Integer>
{
    UserEntity findByMailAndPassword(String mail, String password);
}
