package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(nullable = false)
    private int id;

    @Column(nullable = true)
    @Max(30)
    private String nombres;

    @Column(nullable = true)
    @Max(45)
    private String apellidos;

    @Column(nullable = false)
    @Max(10)
    private Integer celular;

    @Column(nullable = false)
    @Max(10)
    private Integer cedula_Identidad;

    @Column(nullable = true)
    private BigDecimal sueldo;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private Date fecha_Nacimiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Max(30) String getNombres() {
        return nombres;
    }

    public void setNombres(@Max(30) String nombres) {
        this.nombres = nombres;
    }

    public @Max(45) String getApellidos() {
        return apellidos;
    }

    public void setApellidos(@Max(45) String apellidos) {
        this.apellidos = apellidos;
    }

    public @Max(10) Integer getCelular() {
        return celular;
    }

    public void setCelular(@Max(10) Integer celular) {
        this.celular = celular;
    }

    public @Max(10) Integer getCedula_Identidad() {
        return cedula_Identidad;
    }

    public void setCedula_Identidad(@Max(10) Integer cedula_Identidad) {
        this.cedula_Identidad = cedula_Identidad;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_Nacimiento() {
        return fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(Date fecha_Nacimiento) {
        this.fecha_Nacimiento = fecha_Nacimiento;
    }
}
