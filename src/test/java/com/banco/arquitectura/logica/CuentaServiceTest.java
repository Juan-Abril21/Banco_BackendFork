package com.banco.arquitectura.logica;

import com.banco.arquitectura.bd.jpa.ClienteJPA;
import com.banco.arquitectura.bd.jpa.CuentaJPA;
import com.banco.arquitectura.bd.orm.ClienteORM;
import com.banco.arquitectura.bd.orm.CuentaORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CuentaServiceTest {

    @Mock
    CuentaJPA cuentaJPA;

    @Mock
    ClienteJPA clienteJPA;

    @InjectMocks
    CuentaService serviceCuenta;

    @Test
    void When_crearCuenta_Then_returnId() {
        Mockito.when(clienteJPA.findByCedula("123")).thenReturn(java.util.Optional.of(new ClienteORM()));
        serviceCuenta.crearCuenta("123");
        Mockito.verify(cuentaJPA).save(Mockito.any());
    }

    @Test
    void Given_cedulaNoExistente_When_crearCuenta_Then_throwArithmeticException() {
        Mockito.when(clienteJPA.findByCedula("123")).thenReturn(java.util.Optional.empty());
        Assertions.assertThrows(ArithmeticException.class,
                () -> serviceCuenta.crearCuenta("123")
        );
    }

    @Test
    void When_depositar_Then_returnTrue() {
        CuentaORM cuentaORM = new CuentaORM();
        cuentaORM.setSaldo(0.0);
        Mockito.when(cuentaJPA.findById(1L)).thenReturn(java.util.Optional.of(cuentaORM));
        serviceCuenta.depositar(1L, 100.0);
        assertEquals(100.0, cuentaORM.getSaldo());
    }

    @Test
    void Given_montoNegativo_When_depositar_Then_throwArithmeticException() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> serviceCuenta.depositar(1L, -100.0)
        );
    }

    @Test
    void When_verCuentas_Then_returnList() {
        serviceCuenta.verCuentas();
        Mockito.verify(cuentaJPA).findAll();
    }

    @Test
    void When_verCuentasPorCedula_Then_returnList() {
        serviceCuenta.verCuentasPorCedula("123");
        Mockito.verify(cuentaJPA).findByCliente_Cedula("123");
    }

    @Test
    void When_eliminarCuenta_Then_returnTrue() {
        CuentaORM cuentaORM = new CuentaORM();
        cuentaORM.setId(1L);
        Mockito.when(cuentaJPA.findById(1L)).thenReturn(java.util.Optional.of(cuentaORM));
        serviceCuenta.eliminarCuenta(1L);
        Mockito.verify(cuentaJPA).deleteById(1L);
    }

    @Test
    void Given_cuentaNoExistente_When_eliminarCuenta_Then_throwArithmeticException() {
        Mockito.when(cuentaJPA.findById(1L)).thenReturn(java.util.Optional.empty());
        Assertions.assertThrows(ArithmeticException.class,
                () -> serviceCuenta.eliminarCuenta(1L)
        );
    }


}