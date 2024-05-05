package com.example.sportgym.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table
public class Prestamos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSolicitud;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaPrestamo;

    private String nombreUsuario;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idInventario")
    private Inventario inventario;

    @Override
    public String toString() {
        return "Prestamos{" +
                "idSolicitud=" + idSolicitud +
                ", fechaPrestamo=" + fechaPrestamo +
                ", nombreUsuario=" + nombreUsuario +
                ", inventario=" + inventario +
                '}';
    }
}
