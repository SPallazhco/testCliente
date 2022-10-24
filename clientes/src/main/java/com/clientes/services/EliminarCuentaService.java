package com.clientes.services;

import com.clientes.dao.CuentaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EliminarCuentaService {

    @Autowired
    CuentaDao cuentaDao;

    public Integer eliminarCuenta(Integer idCuenta) {
        return cuentaDao.eliminarCuenta(idCuenta);
    }
}
