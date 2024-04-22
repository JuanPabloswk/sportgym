package com.example.sportgym.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
//ver si se cambia @ToString por @Builder
//queda pendiente si usar metodos como unique en la base de datos
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

