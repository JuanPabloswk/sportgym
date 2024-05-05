package com.example.sportgym.service;

import com.example.sportgym.repository.ProductosDao;
import com.example.sportgym.model.Productos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductosImpl implements IProductos {

    @Autowired
    private ProductosDao productosDao;

    @Transactional
    @Override
    public Productos save(Productos productos) {
        return productosDao.save(productos);
    }

    @Transactional(readOnly = true)
    @Override
    public Productos findById(Integer idProductos) {
        return productosDao.findById(idProductos).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Productos productos) {
        productosDao.delete(productos);
    }

}
