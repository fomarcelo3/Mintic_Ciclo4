package com.mintic.proyecto.catalogo.repository.crud;

import com.mintic.proyecto.catalogo.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Interfaz clase User
public interface UserCrudRepository extends CrudRepository<User,Integer> {
    public User findByUser_emailAndUser_password(String email, String password);

    public User findByUser_email(String email);
}
