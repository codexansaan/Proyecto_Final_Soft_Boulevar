package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMenu;

    @Column(nullable = false)
    private String name;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "menu")
    private List<Product> products;

}