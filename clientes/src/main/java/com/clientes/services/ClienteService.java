package com.clientes.services;

import com.clientes.dao.ClienteDao;
import com.clientes.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;
    public Cliente getCliente(String idPersona) {
        Cliente cliente = clienteDao.getCliente(idPersona);
        return cliente;
    }

    public Integer eliminarCliente(Integer idCliente) {
        Integer cliente = clienteDao.eliminarCliente(idCliente);
        return cliente;
    }
}
