package com.mintic.proyecto.catalogo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Representa a un usuario administativo
 * @author Fredy
 */

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,length = 50, unique = true)
    private  String user_email;
    @Column(nullable = false,length = 80)
    private  String user_name;
    @Column(nullable = false,length = 50)
    private  String user_password;
}
