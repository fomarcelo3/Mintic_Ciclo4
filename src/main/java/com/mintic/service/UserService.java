package com.mintic.service;

import com.mintic.model.User;
import com.mintic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Servicio clase user
@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    //metodo para listar usuarios BD
    public List<User> getAll() { return userRepository.getAll();}

    //Metodo para agregar usuario
    public User save(User user){
        if (user.getId() == null){
            if (existeEmail(user.getEmail()) == false){
                return userRepository.save(user);
            }else {
                return  user;
            }
        }else{
            return user;
        }
    }

    //Metodo para validar email
    public boolean existeEmail(String email){
        return  userRepository.validateEmail(email);
    }

    //Metodo para iniciar sesion
    public User singIn(String email, String password){
        Optional<User> userBD = userRepository.singIn(email, password);

        if (userBD.isEmpty()){
            return new User(email,password,"NO DEFINIDO");
        }else{
            return userBD.get();
        }
    }



}
