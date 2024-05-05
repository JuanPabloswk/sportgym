package com.example.sportgym.Repository;

import com.example.sportgym.Model.Orden;
import com.example.sportgym.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
    List<Orden> findByUsuario(Usuario usuario);
}
