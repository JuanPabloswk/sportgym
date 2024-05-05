package com.example.sportgym.Service;

import com.example.sportgym.Model.Orden;
import com.example.sportgym.Model.Usuario;

import java.util.List;
import java.util.Optional;

public interface OrdenService {
    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);

}
