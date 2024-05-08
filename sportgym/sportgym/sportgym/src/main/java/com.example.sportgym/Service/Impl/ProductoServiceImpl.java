package com.example.sportgym.Service.Impl;

import com.example.sportgym.Model.Producto;
import com.example.sportgym.Repository.ProductoRepository;
import com.example.sportgym.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para la gestión de producto.
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Obtiene una lista de todos los productos.
     *
     * @return Lista de productos.
     */
    @Override
    public List<Producto> listarProducto() {return (List<Producto>) productoRepository.findAll();}

    /**
     * Obtiene una lista paginada de producto.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de producto.
     */
    public Page<Producto> listarProductoPaginado(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return Optional.empty();
    }

    /**
     * Guarda un objeto Inventario en la base de datos.
     *
     * @param producto Objeto Inventario a guardar.
     */
    @Override
    public void guardar(Producto producto) {
        productoRepository.save(producto);
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return Objeto Producto encontrado, o null si no se encuentra.
     */
    @Override
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    /**
     * Elimina un objeto producto de la base de datos.
     *
     * @param id ID del Producto a eliminar.
     */
    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

}
