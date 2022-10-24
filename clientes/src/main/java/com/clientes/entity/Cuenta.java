package com.clientes.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cuenta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcuenta")
    private Integer idcuenta;
    @Basic
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Basic
    @Column(name = "saldo_inicial")
    private Long saldoInicial;
    @Basic
    @Column(name = "estado")
    private Byte estado;
    @Basic
    @Column(name = "cliente_idcliente")
    private Integer clienteIdcliente;

    public Integer getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Long saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public Integer getClienteIdcliente() {
        return clienteIdcliente;
    }

    public void setClienteIdcliente(Integer clienteIdcliente) {
        this.clienteIdcliente = clienteIdcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(idcuenta, cuenta.idcuenta) && Objects.equals(tipoCuenta, cuenta.tipoCuenta) && Objects.equals(saldoInicial, cuenta.saldoInicial) && Objects.equals(estado, cuenta.estado) && Objects.equals(clienteIdcliente, cuenta.clienteIdcliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcuenta, tipoCuenta, saldoInicial, estado, clienteIdcliente);
    }
}
