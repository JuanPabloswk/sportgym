package com.example.sportgym.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreImplemento;

    private Integer cantidad;

    @Column(length = 5000) // Ajusta la longitud según tu necesidad
    private String imagen;

    private Integer precio;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private CatImplementos catImplementos;


    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombreImplemento='" + nombreImplemento + '\'' +
                ", cantidad=" + cantidad +
                ", imageUrl" + imagen +
                ", precio=" + precio + '\'' +
                '}';
    }
}
