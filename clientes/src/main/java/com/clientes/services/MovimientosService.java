package com.clientes.services;

import com.clientes.dao.CuentaDao;
import com.clientes.dao.MovimientosDao;
import com.clientes.entity.Movimientos;
import com.clientes.models.MovimientosModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class MovimientosService {

    @Autowired
    MovimientosDao movimientosDao;

    @Autowired
    CuentaDao cuentaDao;

    private Long saldoActual;

    private Date fromDate;
    private Date toDate;

    public MovimientosModel generarMovimientos(MovimientosModel movimientosModel) {

        saldoActual = movimientosDao.getSaldoActual(Integer.valueOf(movimientosModel.getTblMovimientos().getIdCuenta()));
        if(saldoActual == null) {
            saldoActual = cuentaDao.getSaldoInicial(Integer.valueOf(movimientosModel.getTblMovimientos().getIdCuenta())).getSaldoInicial();
            if(saldoActual == null){
                movimientosModel.setCodigoRespuesta("004");
                movimientosModel.setMensajeUsuario("LA CUENTA INGRESADA NO EXISTE");
                movimientosModel.setMensajeTecnico("NO EXISTE EL IDCUENTA EN LA BD");
            } else{
                // Movimientos
                hacerMoviminetos(movimientosModel, saldoActual);
            }
        } else {
            // Movimientos
            hacerMoviminetos(movimientosModel, saldoActual);
        }
        return movimientosModel;
    }

    private void hacerMoviminetos(MovimientosModel movimientosModel, Long saldoActual) {
        Movimientos movimientos = new Movimientos();
        Date fechaMovimiento = Date.valueOf(movimientosModel.getTblMovimientos().getFecha()); // 2020-03-25
        log.info(movimientosModel.getTblMovimientos().getTipoMovimiento());
        if(movimientosModel.getTblMovimientos().getTipoMovimiento().equals("CREDITO")){
            Long saldoFinal = saldoActual + Long.parseLong(movimientosModel.getTblMovimientos().getValor());
            movimientos.setTipoMovimiento(movimientosModel.getTblMovimientos().getTipoMovimiento());
            movimientos.setFecha(fechaMovimiento);
            movimientos.setSaldo(saldoFinal);
            movimientos.setValor(Long.parseLong(movimientosModel.getTblMovimientos().getValor()));
            movimientos.setCuentaIdcuenta(Integer.valueOf(movimientosModel.getTblMovimientos().getIdCuenta()));
            movimientosModel.setCodigoRespuesta("000");
            movimientosModel.setMensajeUsuario("ACREDITACION CORRECTA");
            movimientosDao.generarMovimiento(movimientos);
        } else if (movimientosModel.getTblMovimientos().getTipoMovimiento().equals("DEBITO")){
            if(Long.parseLong(movimientosModel.getTblMovimientos().getValor()) > saldoActual){
                movimientosModel.setCodigoRespuesta("006");
                movimientosModel.setMensajeUsuario("DEBITO NO REALIZADO POR FALTA DE FONDOS");
            } else {
                Long saldoFinal = saldoActual - Long.parseLong(movimientosModel.getTblMovimientos().getValor());
                movimientos.setTipoMovimiento(movimientosModel.getTblMovimientos().getTipoMovimiento());
                movimientos.setFecha(fechaMovimiento);
                movimientos.setSaldo(saldoFinal);
                movimientos.setValor(-Long.parseLong(movimientosModel.getTblMovimientos().getValor()));
                movimientos.setCuentaIdcuenta(Integer.valueOf(movimientosModel.getTblMovimientos().getIdCuenta()));
                movimientosDao.generarMovimiento(movimientos);
                movimientosModel.setCodigoRespuesta("000");
                movimientosModel.setMensajeUsuario("DEBITO REALIZADO CORRECTAMENTE");
            }
        } else {
            movimientosModel.setCodigoRespuesta("005");
            movimientosModel.setMensajeUsuario("MOVIMIENTO NO PARAMETRIZADO");
        }

    }


    public List<Movimientos> movimientosDate(String fromDate, String toDate) {
        this.fromDate = Date.valueOf(fromDate);
        this.toDate = Date.valueOf(toDate);
        List<Movimientos> movimientosDate = movimientosDao.getMovimientosFecha(this.fromDate, this.toDate);
        return movimientosDate;
    }

    public Integer eliminarMovimiento(Integer idMovimiento) {
        return movimientosDao.eliminarMovimiento(idMovimiento);
    }
}
