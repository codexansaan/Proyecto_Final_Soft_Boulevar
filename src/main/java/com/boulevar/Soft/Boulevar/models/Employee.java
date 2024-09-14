package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idEmployee;

    private String name;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = true)
    private String phone;

    @Column(nullable = false, name = "id_number")
    private String idNumber;

    private Integer salary;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate birthdate;

    @Column(nullable = false)
    private  String image;

    // Relación con Usuario usando la clave primaria
    @OneToOne(targetEntity = User.class, cascade = CascadeType.PERSIST)
    private User user;

}
