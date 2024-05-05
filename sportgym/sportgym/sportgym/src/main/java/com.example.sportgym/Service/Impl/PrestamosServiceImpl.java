package com.example.sportgym.Service.Impl;

import com.example.sportgym.Model.Prestamos;
import com.example.sportgym.Model.Producto;
import com.example.sportgym.Repository.ProductoRepository;
import com.example.sportgym.Repository.PrestamoRepository;
import com.example.sportgym.Service.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para la gestión de préstamos.
 */
@Service
public class PrestamosServiceImpl implements PrestamosService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Obtiene una lista de todos los préstamos.
     *
     * @return Lista de préstamos.
     */
    @Override
    public List<Prestamos> listarPrestamos() {
        return prestamoRepository.findAll();
    }

    /**
     * Registra una solicitud de préstamo y actualiza el producto.
     *
     * @param prestamos Objeto Prestamos que representa la solicitud de préstamo.
     */
    @Override
    public void solicitudPrestamo(Prestamos prestamos) {
        Producto producto = prestamos.getProducto();

        int cantidadActual = producto.getCantidad();
        if(cantidadActual > 0){
            cantidadActual--;
            producto.setCantidad(cantidadActual);
            productoRepository.save(producto);
        }
        prestamoRepository.save(prestamos);
    }

    /**
     * Obtiene una lista paginada de préstamos.
     *
     * @param pageable Objeto Pageable para la paginación.
     * @return Página de préstamos.
     */
    @Override
    public Page<Prestamos> listarPrestamosPaginado(Pageable pageable) {
        return prestamoRepository.findAll(pageable);
    }
}
