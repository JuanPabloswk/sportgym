package com.example.sportgym.Service.Impl;

import com.example.sportgym.Model.Orden;
import com.example.sportgym.Model.Usuario;
import com.example.sportgym.Repository.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenServiceImpl {

    @Autowired
    private OrdenRepository ordenRepository;


    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }


    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }


    public List<Orden> findByUsuario(Usuario usuario) {
        return ordenRepository.findByUsuario(usuario);
    }


    public Optional<Orden> findById(Long id) {
        return ordenRepository.findById(id);
    }

}
