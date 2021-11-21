package com.mintic.proyecto.catalogo.service;

import com.mintic.proyecto.catalogo.model.User;
import com.mintic.proyecto.catalogo.repository.UserRepository;
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
            return  userRepository.save(user);
        }else{
            Optional<User> user1 = userRepository.getUser(user.getId());

            if (user1.isEmpty()){
                return userRepository.save(user);
            }else {
                return  user;
            }
        }
    }

    //Metodo para iniciar sesion
    public User singIn(String email, String password){
        User userBD = userRepository.singIn(email, password);

        if (userBD.getId() != null){
            return userBD;
        }else {
            User userR = new User(null,email,"NO DEFINIDO",password);
            return  userR;
        }

    }

    //Metodo para validar email
    public boolean validateEmail(String email){
        User userBD = userRepository.validateEmail(email);

        if (userBD.getId() == null){
            return false;
        }else {
            return true;
        }
    }
}
