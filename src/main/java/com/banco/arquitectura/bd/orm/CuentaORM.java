package com.banco.arquitectura.bd.orm;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "cuentas")
@Entity
@Data
@NoArgsConstructor
public class CuentaORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cedula;
    @Column
    private String nombre;
    @Column
    private Double saldo;
    @Column
    private LocalDate fecha_creacion;

}
