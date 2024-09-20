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
public class Administrator {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdministrator;

    @OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    private User user;

}