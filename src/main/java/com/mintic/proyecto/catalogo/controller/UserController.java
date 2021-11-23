package com.mintic.proyecto.catalogo.controller;

import com.mintic.proyecto.catalogo.model.User;
import com.mintic.proyecto.catalogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//clase controlador de la entidad User
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    //instancia clase servicio
    private UserService userService;

    //metodo para obtener todos los registros de la entidad user
    @GetMapping("/all")
    public List<User> getAll(){return userService.getAll();}

    //Metodo para registrar un nuevo elemento en la entidad User
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){ return  userService.save(user);}

    //Metodo para validar usuario por email
    @GetMapping("/{email}")
    public boolean validateUser(@PathVariable String email){ return userService.existeEmail(email);}

    //Metodo para iniciar sesion de usuario
    @GetMapping("/{email}/{password}")
    public User signIn(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.singIn(email,password);
    }

}
