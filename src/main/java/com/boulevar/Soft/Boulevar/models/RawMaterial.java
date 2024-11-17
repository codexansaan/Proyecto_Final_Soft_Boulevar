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
public class RawMaterial {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idRawMaterial;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double stock;

    @Column(nullable = false, name = "unit_of_measurement")
    private String unitOfMeasurement;

    @Column(nullable = false, name = "unit_price")
    private Double unitPrice;

}
