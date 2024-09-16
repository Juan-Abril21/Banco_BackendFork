package com.banco.arquitectura.bd.jpa;

import com.banco.arquitectura.bd.orm.CuentaORM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuentaJPA extends JpaRepository<CuentaORM, Long> {
    List<CuentaORM> findByCliente_Cedula(String cedula);
}
