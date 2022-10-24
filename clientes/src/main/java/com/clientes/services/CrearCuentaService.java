package com.clientes.services;

import com.clientes.dao.CuentaDao;
import com.clientes.entity.Cuenta;
import com.clientes.models.CuentaModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CrearCuentaService {
    @Autowired
    CuentaDao cuentaDao;

    public CuentaModel crearCuenta(CuentaModel cuentaModel) {
        try{
            Cuenta cuenta = new Cuenta();
            cuenta.setTipoCuenta(cuentaModel.getTblCuenta().getTipoCuenta());
            cuenta.setEstado((byte) cuentaModel.getTblCuenta().getEstado());
            cuenta.setSaldoInicial(cuentaModel.getTblCuenta().getSaldoInicial());
            log.info(cuentaModel.getTblCuenta().getIdCliente());
            cuenta.setClienteIdcliente(Integer.valueOf(cuentaModel.getTblCuenta().getIdCliente()));
            cuentaDao.crearCuenta(cuenta);
            cuentaModel.setCodigoRespuesta("000");
            cuentaModel.setMensajeUsuario("CUENTA CREADA EXITOSAMENTE");
        }catch (Exception e){
            cuentaModel.setCodigoRespuesta("003");
            cuentaModel.setMensajeUsuario("ERROR AL CREAR CUENTA");
            cuentaModel.setMensajeTecnico(e.toString());
        }
        return cuentaModel;
    }
}
