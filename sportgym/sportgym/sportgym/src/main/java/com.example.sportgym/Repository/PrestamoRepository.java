package com.example.sportgym.Repository;

import com.example.sportgym.Model.Prestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona métodos para acceder y manipular datos de préstamos en la base de datos.
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamos, Long> {
}
