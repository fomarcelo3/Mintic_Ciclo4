package com.mintic.proyecto.catalogo.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Representa a un usuario administativo
 * @author Fredy
 */

@Entity
@Table(name = "user",indexes=@Index(name="indx_email", columnList = "user_email", unique = true))
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email",nullable = false,length = 50)
    private  String email;
    @NonNull
    @Column(name = "user_password",nullable = false,length = 50)
    private  String password;
    @NonNull
    @Column(name = "user_name",nullable = false,length = 50)
    private  String name;

}
