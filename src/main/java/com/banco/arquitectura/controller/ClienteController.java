package com.banco.arquitectura.controller;

import com.banco.arquitectura.bd.orm.ClienteORM;
import com.banco.arquitectura.controller.dto.ClienteDTO;
import com.banco.arquitectura.logica.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping(path = "/cliente")
    public String guardarCliente(@RequestBody ClienteDTO clienteDTO) {
        clienteService.crearCliente(clienteDTO.nombre(), clienteDTO.cedula());
        return "Cliente guardado";
    }

    @GetMapping(path = "/clientes")
    public List<ClienteORM> verClientes() {
        return clienteService.verClientes();
    }
}
