package com.boulevar.Soft.Boulevar.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoCliente;

    @Column(nullable = false)
    private int numeroIdentificacion;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private int numeroContacto;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "cliente")  // El lado "muchos" tiene una referencia al lado "uno"
    private Set<Orden> ordenes;

}
