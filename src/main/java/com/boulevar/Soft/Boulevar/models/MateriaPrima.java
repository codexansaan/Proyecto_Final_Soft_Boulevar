package com.boulevar.Soft.Boulevar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "materiaprima")

public class MateriaPrima {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idMateriaPrima;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double stock;

    @Column(nullable = false)
    private String unidadmedida;

    @Column(nullable = false)
    private Double preciounidad;

}
