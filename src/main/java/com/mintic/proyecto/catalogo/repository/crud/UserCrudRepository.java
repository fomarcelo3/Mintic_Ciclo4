package com.mintic.proyecto.catalogo.repository.crud;

import com.mintic.proyecto.catalogo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Interfaz clase User
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);
}
