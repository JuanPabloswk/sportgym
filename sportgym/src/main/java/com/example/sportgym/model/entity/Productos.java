package com.example.sportgym.model.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="productos")
public class productos {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idProductos")
    private int idProductos;

    @Column(name="nombre")
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="precio")
    private int precio;

    @Column(name="contenido")
    private String contenido;

    @Column(name="cantidad")
    private int cantidad;

    @Column(name="tipo")
    private String tipo;

}
