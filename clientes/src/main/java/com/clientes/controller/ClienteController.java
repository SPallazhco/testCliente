package com.clientes.controller;

import com.clientes.entity.Cliente;
import com.clientes.entity.Movimientos;
import com.clientes.models.CuentaModel;
import com.clientes.models.MovimientosModel;
import com.clientes.models.PersonaCliente;
import com.clientes.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    CrearClienteService crearClienteService;

    @Autowired
    CrearCuentaService crearCuetaService;

    @Autowired
    MovimientosService movimientosService;

    @Autowired
    EliminarCuentaService eliminarCuentaService;

    @GetMapping(path = "/getCliente/{idPersona}")
    public Cliente getCliente(@PathVariable(name = "idPersona") String idPersona) {
        Cliente cliente = clienteService.getCliente(idPersona);
        return cliente;
    }

    @GetMapping(path = "/getMovimientosFechas/{one_date}/{two_date}")
    public List<Movimientos> getMovimientosFechas(@PathVariable(name = "one_date") String fromDate, @PathVariable(name = "two_date") String toDate){
        return movimientosService.movimientosDate(fromDate, toDate);
    }

    @PostMapping(path = "/crearCliente")
    public PersonaCliente crearCliente(@Validated @RequestBody String infoCliente){
        return crearClienteService.crearCliente(infoCliente);
    }

    @PostMapping(path = "/crearCuenta")
    public CuentaModel crearCuenta(@Validated @RequestBody CuentaModel cuentaModel){
        return crearCuetaService.crearCuenta(cuentaModel);
    }
    @PostMapping(path = "/movimientos")
    public MovimientosModel movimientos(@Validated @RequestBody MovimientosModel movimientosModel){
        return movimientosService.generarMovimientos(movimientosModel);
    }

    @DeleteMapping(path = "/eliminarCliente/{idCliente}")
    public Integer eliminarCliente(@Validated @PathVariable(value = "idCliente") Integer idCliente){
        return clienteService.eliminarCliente(idCliente);
    }

    @DeleteMapping(path = "/eliminarCuenta/{idCuenta}")
    public Integer eliminarCuenta(@Validated @PathVariable(value = "idCuenta") Integer idCuenta){
        return eliminarCuentaService.eliminarCuenta(idCuenta);
    }

    @DeleteMapping(path = "/eliminarMovimiento/{idMovimiento}")
    public Integer eliminarMovimiento(@Validated @PathVariable(value = "idMovimiento") Integer idMovimiento){
        return movimientosService.eliminarMovimiento(idMovimiento);
    }
}
