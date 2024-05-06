package com.example.sportgym.Model;


import lombok.Getter;
import lombok.Setter;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

/**
 * Clase que representa la entidad Usuario en la base de datos.
 */

@Entity
@Getter
@Setter
@Table(name="usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "direccion")
    private String direccion;

    private Long telefono;

    private String email;

    private String password;

    /**
     * Relación Many-to-Many con la tabla de roles.
     * FetchType.EAGER para cargar los datos relacionados de forma inmediata.
     * CascadeType.ALL para aplicar todas las operaciones de persistencia (insertar, actualizar o eliminar) en cascada.
     */

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario"),
            inverseJoinColumns = @JoinColumn(name= "idRole", referencedColumnName= "idRole")
    )

    private Collection<Rol> roles;

    @OneToMany(mappedBy = "usuario")
    private List<Producto> productos;



    /**
     * Constructor por defecto de la clase Usuario.
     */

    public Usuario() {

    }


    /**
     * Constructor parametrizado para crear un objeto Usuario.
     */

    public Usuario(String nombres, String direccion, String email, String password, Collection<Rol> roles, Long telefono) {
        this.nombres = nombres;
        this.direccion = direccion;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.telefono = telefono;
    }



}
