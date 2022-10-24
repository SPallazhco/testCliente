package com.clientes.repository;

import com.clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Cliente findClienteByPersonaIdpersona(String idPersona);

    Integer removeClienteByIdcliente(Integer idCliente);
}
