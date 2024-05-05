package com.example.sportgym.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cat_productos")
public class CatProductos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    @Override
    public String toString() {
        return "CatProductos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
