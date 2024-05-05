package com.example.sportgym.Service;

import com.example.sportgym.Model.CatProductos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interfaz que define los métodos para el servicio de gestión de categorías de productos.
 */
public interface CatProductosService {

    /**
     * Obtiene una lista de todas las categorías de productos.
     *
     * @return Lista de categorías de productos.
     */
    List<CatProductos> listarCategorias();

    /**
     * Guarda una nueva categoría de productos en la base de datos.
     *
     * @param catProductos Objeto CatProductos que representa la categoría a guardar.
     */
    public void guadar_categoria(CatProductos catProductos);

    /**
     * Obtiene una lista paginada de categorías de productos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de categorías de productos.
     */
    public Page<CatProductos> listarCategoriasPaginado(Pageable pageable);
}
