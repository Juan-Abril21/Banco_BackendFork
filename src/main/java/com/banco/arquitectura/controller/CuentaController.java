package com.banco.arquitectura.controller;

import com.banco.arquitectura.bd.orm.CuentaORM;
import com.banco.arquitectura.controller.dto.CuentaDTO;
import com.banco.arquitectura.controller.dto.DepositoDTO;
import com.banco.arquitectura.logica.CuentaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CuentaController {

    private CuentaService cuentaService;

    @PostMapping(path = "/cuenta")
    public long guardarCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return cuentaService.crearCuenta(cuentaDTO.cedula());
    }

    @PostMapping(path = "/deposito")
    public Double depositar(@RequestBody DepositoDTO depositoDTO) {
        return cuentaService.depositar(depositoDTO.id(), depositoDTO.monto());
    }

    @GetMapping(path = "/cuentas")
    public List<CuentaORM> verCuentas() {
        return cuentaService.verCuentas();
    }

    @GetMapping(path = "/cuentas/{cedula}")
    public List<CuentaORM> verCuentasPorCedula(@PathVariable String cedula) {
        return cuentaService.verCuentasPorCedula(cedula);
    }

    @DeleteMapping(path = "/cuenta/eliminar/{id}")
    public String eliminarCuenta(@PathVariable long id) {
        cuentaService.eliminarCuenta(id);
        return "Cuenta eliminada";
    }
}
