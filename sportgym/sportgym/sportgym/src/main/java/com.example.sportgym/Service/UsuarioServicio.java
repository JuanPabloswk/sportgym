package com.example.sportgym.Service;

import com.example.sportgym.Controller.dto.UsuarioRegistroDTO;
import com.example.sportgym.Model.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los servicios relacionados con la entidad Usuario.
 * Se extiende UserDetailsService para proporcionar la funcionalidad de cargar los detalles del usuario.
 */

public  interface UsuarioServicio extends UserDetailsService {

    /**
     * Método para guardar un nuevo usuario en la base de datos.
     * @param registroDTO DTO que contiene la información del usuario a guardar.
     * @param rol Rol asignado al usuario.
     * @return El usuario guardado en la base de datos.
     */

    public Usuario guardar(UsuarioRegistroDTO registroDTO, String rol);

    /**
     * Método para obtener la lista de todos los usuarios registrados en la base de datos.
     * @return Lista de usuarios registrados.
     */

    public List<Usuario> listarUsuarios();

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);
}
