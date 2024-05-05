package com.example.sportgym.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "detalles")
public class DetalleOrden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Long cantidad;

    private Long precio;

    private Long total;

    @ManyToOne
    private Orden orden;

    @ManyToOne
    private Producto producto;


    public DetalleOrden() {

    }

    public DetalleOrden(Long id, String nombre, Long cantidad, Long precio, Long total) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

}
