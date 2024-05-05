package com.example.sportgym.Service.Impl;

import com.example.sportgym.Model.DetalleOrden;
import com.example.sportgym.Repository.DetalleOrdenRepository;
import com.example.sportgym.Service.DetalleOrdenService;
import org.springframework.beans.factory.annotation.Autowired;

public class DetalleOrdenServiceImpl implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden save(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }
}
