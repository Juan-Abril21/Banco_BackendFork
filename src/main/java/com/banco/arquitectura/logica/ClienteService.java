package com.banco.arquitectura.logica;

import com.banco.arquitectura.bd.jpa.ClienteJPA;
import com.banco.arquitectura.bd.orm.ClienteORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteJPA clienteJPA;

    public boolean crearCliente(String nombre, String Cedula){
        if (clienteJPA.findByCedula(Cedula).isPresent()){
            throw new ArithmeticException("Ya existe un cliente con la cedula: " + Cedula);
        }
        ClienteORM nuevoCliente = new ClienteORM();
        nuevoCliente.setNombre(nombre);
        nuevoCliente.setCedula(Cedula);
        nuevoCliente.setFecha_creacion(LocalDate.now());
        clienteJPA.save(nuevoCliente);
        return true;
    }

    public List<ClienteORM> verClientes(){
        return clienteJPA.findAll();
    }
}
