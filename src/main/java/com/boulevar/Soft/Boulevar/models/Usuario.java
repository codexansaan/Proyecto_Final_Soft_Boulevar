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
    @Setter
    @Getter
    @Column(nullable = false)
    private int codigoUsuario;

    @Column(nullable = false)
    @Setter
    @Getter
    private String password;

    @Column(nullable = false)
    private String turno;

    @ManyToMany
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "codigoUsuario"),
            inverseJoinColumns = @JoinColumn(name = "codigoRol")
    )
    @Getter
    @Setter
    private Set<Rol> roles;

    public Usuario() {
    }

    public Usuario(int codigoUsuario, String password, String turno) {
        this.codigoUsuario = codigoUsuario;
        this.password = password;
    }
}
