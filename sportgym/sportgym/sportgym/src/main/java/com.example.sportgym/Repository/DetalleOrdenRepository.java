package com.example.sportgym.Repository;

import com.example.sportgym.Model.DetalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Long> {
}
