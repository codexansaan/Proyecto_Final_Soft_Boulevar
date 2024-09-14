package com.boulevar.Soft.Boulevar.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerCode;

    @Column(nullable = false)
    private int identificationNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private int phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToMany(targetEntity = Order.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders;

}
