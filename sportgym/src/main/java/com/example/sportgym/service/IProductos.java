package com.example.sportgym.service;

import com.example.sportgym.model.Productos;

public interface IProductos {

    Productos save(Productos productos);

    Productos findById(Integer idProductos);

    void delete(Productos productos);

}
