package com.example.sportgym.Repository;

import com.example.sportgym.Model.CatProductos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de categorías de productos en la base de datos.
 */
@Repository
public interface CatProductosRepository extends JpaRepository<CatProductos,Long> {
}
