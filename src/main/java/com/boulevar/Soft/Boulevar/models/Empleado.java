package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(nullable = false)
    private int idEmpleado;

    @Column(length = 30)
    @Getter
    @Setter
    private String nombres;

    @Column(length = 45)
    @Getter
    @Setter
    private String apellidos;

    @Column(nullable = false)
    @Max(10)
    private String celular;

    @Column(nullable = false)
    @Max(10)
    private String cedula_Identidad;

    @Column
    @Getter
    @Setter
    private Integer sueldo;


    @Column(nullable = false)
    @Getter
    @Setter
    @Email
    private String correo;

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate fecha_Nacimiento;


    public Empleado() {
    }

    public Empleado(String nombres, String apellidos, String celular, String cedula_Identidad, Integer sueldo, String correo, LocalDate fecha_Nacimiento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.cedula_Identidad = cedula_Identidad;
        this.sueldo = sueldo;
        this.correo = correo;
        this.fecha_Nacimiento = fecha_Nacimiento;
    }


    public @Max(10) String getCelular() {
        return celular;
    }

    public void setCelular(@Max(10) String celular) {
        this.celular = celular;
    }

    public @Max(10) String getCedula_Identidad() {
        return cedula_Identidad;
    }

    public void setCedula_Identidad(@Max(10) String cedula_Identidad) {
        this.cedula_Identidad = cedula_Identidad;
    }


    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + idEmpleado +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", celular=" + celular +
                ", cedula_Identidad=" + cedula_Identidad +
                ", sueldo=" + sueldo +
                ", correo='" + correo + '\'' +
                ", fecha_Nacimiento=" + fecha_Nacimiento +
                '}';
    }
}
