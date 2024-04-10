package com.example.sportgym.service;

import com.example.sportgym.model.entity.Productos;

public interface IProductos {
    Productos save(Productos productos);

    Productos findById(Integer idProductos);

    void delete(Productos productos);
}
