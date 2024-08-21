package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;



@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    @Getter
    @Column(nullable = false)
    private int codigoRol;

    @Column(nullable = false, unique = true)
    @Setter
    @Getter
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    @Setter
    @Getter
    private Set<Usuario> usuarios;

    public Rol() {
    }

    public Rol(String nombre) {
        this.nombre = nombre;
    }

}