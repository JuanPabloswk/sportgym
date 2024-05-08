package com.example.sportgym.Model;

import javax.persistence.*;

@Entity
@Table(name = "suscripcion")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long precio;

    private Integer cantidad;

    private String duracion;

    private String disponibilidad;

    @Override
    public String toString() {
        return "Suscripcion{" +
                "id=" + id +
                ", precio='" + precio + '\'' +
                ", cantidad=" + cantidad +
                ", duracion=" + duracion +
                ", disponibilidad=" + disponibilidad + '\'' +
                '}';
    }
}
