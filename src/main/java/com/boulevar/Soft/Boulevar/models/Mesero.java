package com.boulevar.Soft.Boulevar.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "mesero")
public class Mesero {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMesero;

    @OneToOne
    @JoinColumn(name = "codigo_usuario", referencedColumnName = "codigoUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "mesero")  // El lado "muchos" tiene una referencia al lado "uno"
    private Set<Orden> ordenes;

}
