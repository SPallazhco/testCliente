package com.clientes.dao;

import com.clientes.entity.Cuenta;
import com.clientes.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CuentaDao {

    @Autowired
    CuentaRepository cuentaRepository;
    public Cuenta crearCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    public Cuenta getSaldoInicial(Integer idCuenta) {
        return cuentaRepository.findCuentaByIdcuenta(idCuenta);
    }

    public Integer eliminarCuenta(Integer idCuenta) {
        return cuentaRepository.deleteCuentaByIdcuenta(idCuenta);
    }
}
