package com.clientes.repository;

import com.clientes.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PersonaRepository extends JpaRepository<Persona, String> {

}
