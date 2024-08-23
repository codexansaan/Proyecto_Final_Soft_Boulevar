package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "administrador")
public class Administrador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @OneToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigoUsuario")
    @Getter @Setter
    private Usuario usuario;

}
