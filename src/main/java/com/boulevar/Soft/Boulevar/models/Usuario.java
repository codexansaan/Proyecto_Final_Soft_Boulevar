package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;




@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter @Getter
    @Column(nullable = false)
    private int codigoUsuario;

    @Column(nullable = false)
    @Setter @Getter
    private String password;

    @Column(nullable = false)
    @Setter @Getter
    private String turno;

    //Relacion inversa con Empleado
    @OneToOne(mappedBy = "usuario")
    @Getter @Setter
    private Empleado empleado;

    // Relaciones uno a uno con otras entidades
    @OneToOne(mappedBy = "usuario")
    @Getter @Setter
    private Mesero mesero;

    @OneToOne(mappedBy = "usuario")
    @Getter @Setter
    private Cocinero cocinero;

    @OneToOne(mappedBy = "usuario")
    @Getter @Setter
    private Cajero cajero;

    @OneToOne(mappedBy = "usuario")
    @Getter @Setter
    private Administrador administrador;

    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "codigoUsuario"),
            inverseJoinColumns = @JoinColumn(name = "codigoRol")
    )
    @Getter @Setter
    private Set<Rol> roles;

    public Usuario() {
    }

    public Usuario(int codigoUsuario, String password, String turno) {
        this.codigoUsuario = codigoUsuario;
        this.password = password;
    }
}
