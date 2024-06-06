package com.notty.Notty.DataAccess;

import com.notty.Notty.Domain.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity,Integer>
{
    public UserEntity findByMailAndPassword(String mail, String password);
    public UserEntity findByIdUser(Integer id);
    public UserEntity findByMail(String mail);
}
