package com.mintic.repository.crud;

import com.mintic.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Interfaz clase User
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
