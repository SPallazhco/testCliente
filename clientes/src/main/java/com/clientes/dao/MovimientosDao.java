package com.clientes.dao;

import com.clientes.entity.Movimientos;
import com.clientes.repository.MovimientosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class MovimientosDao {

    @Autowired
    MovimientosRepository movimientosRepository;

    public List<Movimientos> getMovimientos(Integer idCuenta) {
        return movimientosRepository.findByCuentaIdcuenta(idCuenta);
    }

    public Long getSaldoActual(Integer idCuenta){
        return movimientosRepository.findSaldoActualByIdCuenta(idCuenta);
    }

    public void generarMovimiento(Movimientos movimientos) {
        movimientosRepository.save(movimientos);
    }

    public List<Movimientos> getMovimientosFecha(Date fromDate, Date toDate) {
        return movimientosRepository.getDataBetween(fromDate, toDate);
    }

    public Integer eliminarMovimiento(Integer idMovimiento) {
        return movimientosRepository.deleteMovimientosByIdmovimientos(idMovimiento);
    }
}
