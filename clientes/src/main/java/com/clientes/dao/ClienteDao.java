package com.clientes.dao;

import com.clientes.entity.Cliente;
import com.clientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDao {

    @Autowired
    ClienteRepository clienteRepository;
    public Cliente getCliente(String idPersona) {
        return  clienteRepository.findClienteByPersonaIdpersona(idPersona);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Integer eliminarCliente(Integer idCliente) {
        return clienteRepository.removeClienteByIdcliente(idCliente);
    }
}
