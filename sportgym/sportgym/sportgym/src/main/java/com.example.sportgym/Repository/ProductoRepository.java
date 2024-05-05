package com.example.sportgym.Repository;

import com.example.sportgym.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de producto en la base de datos.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
}
