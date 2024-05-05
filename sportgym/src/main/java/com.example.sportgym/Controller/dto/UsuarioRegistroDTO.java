package com.example.sportgym.Controller.dto;


import com.example.sportgym.Model.Rol;
import lombok.Getter;
import lombok.Setter;
import java.util.Collection;

/**
 * Esta clase representa un objeto de transferencia de datos (DTO) para el registro de usuarios en la aplicación.
 */

@Getter
@Setter
public class UsuarioRegistroDTO {

    /**
     * Identificador único del usuario.
     */

    private Long id;

    /**
     * Nombres y Apellidos del usuario.
     */

    private String nombre;

    private String apellido;

    /**
     * Correo electrónico y contraseña del usuario.
     */

    private String email;

    private String password;

    /**
     * Rol del USER, (USER O ADMIN).
     */

    private Collection<Rol> rol;

    /**
     * Número telefónico del USER.
     */

    private Long telefono;

    /**
     * Constructor de la clase que inicializa todos los atributos.
     */

    public UsuarioRegistroDTO(Long id, String nombre, String apellido, String email, String password, Collection<Rol> rol, Long telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.telefono = telefono;
    }

    public UsuarioRegistroDTO() {

    }
}
