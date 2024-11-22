package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Waiter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idWaiter;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_code")
    private User user;

    @OneToMany(targetEntity = Pedido.class, fetch = FetchType.LAZY, mappedBy = "waiter")  // El lado "muchos" tiene una referencia al lado "uno"
    private List<Pedido> pedidos;

}
