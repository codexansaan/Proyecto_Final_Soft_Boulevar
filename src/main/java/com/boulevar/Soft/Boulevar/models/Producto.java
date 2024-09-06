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
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private  String image;

    @Column(nullable = true)
    private String category;

    @Column(nullable = true)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "idMenu")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "idOrden")  // Clave foránea en la tabla de Producto
    private Orden orden;

}
