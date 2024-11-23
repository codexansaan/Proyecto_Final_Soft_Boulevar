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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column
    private String description;

    @Column(nullable = false)
    private  String image;

    @Column
    private String category;

    @Column
    private int quantity;

    @ManyToOne(targetEntity = Menu.class)
    private Menu menu;

    @ManyToOne(targetEntity = Pedido.class)
    private Pedido pedido;

}
