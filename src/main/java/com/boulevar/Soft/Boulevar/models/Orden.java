package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orden")
public class Orden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrden;

    @Column(nullable = false)
    private int numeroMesa;

    @Column(nullable = false)
    private LocalDate fechaHora;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private int total;

    @Column(nullable = false)
    private String notas;

    @OneToMany
    @JoinColumn(name = "idOrden")
    private Set<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "idMesero")  // Clave foránea en la tabla de Orden
    private Mesero mesero;

    @ManyToOne
    @JoinColumn(name = "idCliente")  // Clave foránea en la tabla de Orden
    private Cliente cliente;

}
