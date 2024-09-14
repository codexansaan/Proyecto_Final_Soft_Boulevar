package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orden")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @Column(nullable = false)
    private int tableNumber;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private String notes;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER, mappedBy = "order")//Relacion de uno a muchos, clase objetivo Product, Carga lista de productos, relaciona con productos
    private List<Product> products;

    @ManyToOne(targetEntity = Waiter.class)//Relacion de muchas ordenes a un mesero
    private Waiter waiter;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;

}
