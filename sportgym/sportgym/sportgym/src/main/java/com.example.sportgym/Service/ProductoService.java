package com.example.sportgym.Service;

import com.example.sportgym.Model.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define los métodos para el servicio de gestión de producto.
 */
public interface ProductoService {

    /**
     * Obtiene una lista de todos los productos.
     *
     * @return Lista de producto.
     */
    public List<Producto> listarProducto();

    /**
     * Guarda un objeto Producto en la base de datos.
     *
     * @param producto Objeto Producto a guardar.
     */
    public void guardar(Producto producto);

    /**
     * Busca un objeto Producto por su ID.
     *
     * @param id ID del Producto a buscar.
     * @return Objeto Producto encontrado, o null si no se encuentra.
     */
    public Producto buscarPorId(Long id);

    /**
     * Elimina un objeto Producto de la base de datos.
     *
     * @param id ID del Producto a eliminar.
     */
    public void eliminar(Long id);

    /**
     * Obtiene una lista paginada de producto.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de producto.
     */
    public Page<Producto> listarProductoPaginado(Pageable pageable);

    Optional<Producto> get(Integer id);

    //public Producto agregarProductoAlCarrito(Long idProducto);
}
