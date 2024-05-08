package com.example.sportgym.Service.Impl;


import com.example.sportgym.Model.Suscripcion;
import com.example.sportgym.Repository.SuscripcionRepository;
import com.example.sportgym.Service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {

    @Autowired
    private SuscripcionRepository suscripcionRepository;

    @Override
    public List<Suscripcion> listarSuscripcion() {
        return suscripcionRepository.findAll();
    }

}
