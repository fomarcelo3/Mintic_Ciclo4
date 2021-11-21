package com.mintic.proyecto.catalogo.repository;

import com.mintic.proyecto.catalogo.model.User;
import com.mintic.proyecto.catalogo.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//Clase repositorio de la entidad User
@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){return (List<User>) userCrudRepository.findAll();}

    public Optional<User> getUser(int id) {return  userCrudRepository.findById(id);}

    public  User save(User user) { return  userCrudRepository.save(user);}

    public  void delete(User user) { userCrudRepository.delete(user);}

    public User singIn(String email, String password){
        return userCrudRepository.findByUser_emailAndUser_password(email,password);
    }

    public User validateEmail(String email) { return userCrudRepository.findByUser_email(email);}
}
