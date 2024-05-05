package com.example.sportgym.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreProducto;

    private Integer cantidad;

    @Column(length = 5000) // Ajusta la longitud según tu necesidad
    private String imagen;

    private Integer precio;

    @ManyToOne
    private CatProductos catProductos;

    @ManyToOne
    private Usuario usuario;


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", cantidad=" + cantidad +
                ", imagen='" + imagen + '\'' +
                ", precio=" + precio +
                ", catProductos=" + catProductos +
                ", usuario=" + usuario +
                '}';
    }
}
