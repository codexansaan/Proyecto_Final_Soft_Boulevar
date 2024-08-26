package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;




@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private int codigoUsuario;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String turno;

    //Relacion inversa con Empleado
    @OneToOne(mappedBy = "usuario")
    private Empleado empleado;

    // Relaciones uno a uno con otras entidades
    @OneToOne(mappedBy = "usuario")
    private Mesero mesero;

    @OneToOne(mappedBy = "usuario")
    private Cocinero cocinero;

    @OneToOne(mappedBy = "usuario")
    private Cajero cajero;

    @OneToOne(mappedBy = "usuario")
    private Administrador administrador;

    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "codigoUsuario"),
            inverseJoinColumns = @JoinColumn(name = "codigoRol")
    )

    private Set<Rol> roles;

}
