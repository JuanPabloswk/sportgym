package com.example.sportgym.model.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer id_usuario;

    @Column(name="primer_nombre")
    private String primer_nombre;

    @Column(name="segundo_nombre")
    private String segundo_nombre;

    @Column(name="correo")
    private String correo;

    @Column(name="contrasena")
    private String contrasena;

}

