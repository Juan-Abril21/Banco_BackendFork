package com.banco.arquitectura.logica;

import com.banco.arquitectura.bd.jpa.ClienteJPA;
import com.banco.arquitectura.bd.jpa.CuentaJPA;
import com.banco.arquitectura.bd.orm.CuentaORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@AllArgsConstructor
public class CuentaService {

    private final CuentaJPA cuentaJPA;
    private final ClienteJPA clienteJPA;

    public long crearCuenta(String cedula){
        if (!clienteJPA.findByCedula(cedula).isPresent()){
            throw new ArithmeticException("No existe un cliente con la cedula: " + cedula);
        }
        CuentaORM nuevaCuenta = new CuentaORM();
        nuevaCuenta.setCedula(cedula);
        nuevaCuenta.setNombre(clienteJPA.findByCedula(cedula).get().getNombre());
        nuevaCuenta.setSaldo(0.0);
        nuevaCuenta.setFecha_creacion(LocalDate.now());
        cuentaJPA.save(nuevaCuenta);
        CuentaORM cuentaGuardada = cuentaJPA.save(nuevaCuenta);
        return cuentaGuardada.getId();
    }

    public Double depositar(long id, double monto){
        if(monto <= 0){
            throw new ArithmeticException("El monto a depositar debe ser mayor a 0");
        }
        CuentaORM cuenta = cuentaJPA.findById(id).get();
        cuenta.setSaldo(cuenta.getSaldo() + monto);
        cuentaJPA.save(cuenta);
        CuentaORM cuentaGuardada = cuentaJPA.save(cuenta);
        return cuentaGuardada.getSaldo();
    }

    public List<CuentaORM> verCuentas(){
        return cuentaJPA.findAll();
    }

    public List<CuentaORM> verCuentasPorCedula(String cedula){
        return cuentaJPA.findByCedula(cedula);
    }

    public void eliminarCuenta(long id){
        if (cuentaJPA.findById(id).isEmpty()){
            throw new ArithmeticException("No existe una cuenta con el id: " + id);
        }
        cuentaJPA.deleteById(id);
    }


}
