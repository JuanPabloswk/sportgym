package com.example.sportgym.service;

import com.example.sportgym.model.Usuarios;

public interface IUsuarios {

    Usuarios save(Usuarios usuarios);

    Usuarios findById(Integer id_usuarios);

    void delete(Usuarios usuarios);

}
