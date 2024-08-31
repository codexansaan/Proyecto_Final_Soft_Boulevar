package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor @Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private int idEmpleado;

    @Column(length = 30)
    private String nombres;

    @Column(length = 45)
    private String apellidos;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String cedulaIdentidad;

    @Column
    private Integer sueldo;

    @Column(nullable = false)
    @Email
    private String correo;

    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    // Relación con Usuario usando la clave primaria codigoUsuario
    @OneToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigoUsuario")
    private Usuario usuario;

}
