package com.example.sportgym.Repository;

import com.example.sportgym.Model.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de inventario en la base de datos.
 */
@Repository
public interface InventarioRepository extends JpaRepository<Inventario,Long> {
}
