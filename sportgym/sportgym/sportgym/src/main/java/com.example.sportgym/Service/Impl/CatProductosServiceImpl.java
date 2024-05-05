package com.example.sportgym.Service.Impl;

import com.example.sportgym.Model.CatProductos;
import com.example.sportgym.Repository.CatProductosRepository;
import com.example.sportgym.Service.CatProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la gestión de categorías de productos.
 */
@Service
public class CatProductosServiceImpl implements CatProductosService {

    @Autowired
    private CatProductosRepository catProductosRepository;

    /**
     * Obtiene una lista de todas las categorías de productos.
     *
     * @return Lista de categorías de productos.
     */
    @Override
    public List<CatProductos> listarCategorias() {
        return (List<CatProductos>) catProductosRepository.findAll();
    }

    /**
     * Guarda una nueva categoría de productos en la base de datos.
     *
     * @param catProductos Objeto CatProductos que representa la categoría a guardar.
     */
    @Override
    public void guadar_categoria(CatProductos catProductos) {
        catProductosRepository.save(catProductos);
    }

    /**
     * Obtiene una lista paginada de categorías de productos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de categorías de productos.
     */
    @Override
    public Page<CatProductos> listarCategoriasPaginado(Pageable pageable) {
        return catProductosRepository.findAll(pageable);
    }

}
