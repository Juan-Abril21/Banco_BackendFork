package com.banco.arquitectura.logica;

import com.banco.arquitectura.bd.jpa.ClienteJPA;
import com.banco.arquitectura.bd.orm.ClienteORM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @Mock
    ClienteJPA clienteJPA;

    @InjectMocks
    ClienteService service;

    @Test
    void When_crearCliente_Then_returnTrue() {
        boolean resultado = service.crearCliente("Juan", "123");
        Assertions.assertTrue(resultado);
        Mockito.verify(clienteJPA).save(Mockito.any());
    }

    @Test
    void Given_cedulaExistente_When_crearCliente_Then_throwArithmeticException() {
        Mockito.when(clienteJPA.findByCedula("123")).thenReturn(java.util.Optional.of(new ClienteORM()));
        Assertions.assertThrows(ArithmeticException.class,
                () -> service.crearCliente("Juan", "123")
        );
    }
    @Test
    void When_verClientes_Then_returnList() {
        service.verClientes();
        Mockito.verify(clienteJPA).findAll();
    }


}