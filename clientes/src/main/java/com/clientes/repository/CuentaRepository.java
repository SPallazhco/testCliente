package com.clientes.repository;

import com.clientes.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {

    Cuenta findCuentaByIdcuenta(Integer idCuenta);

    Integer deleteCuentaByIdcuenta(Integer idCuenta);

}
