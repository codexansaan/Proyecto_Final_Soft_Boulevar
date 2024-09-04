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
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = true)
    private String ingredientes;

    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "idOrden")  // Clave foránea en la tabla de Producto
    private Orden orden;

}
