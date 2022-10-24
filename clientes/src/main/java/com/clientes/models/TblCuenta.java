package com.clientes.models;

public class TblCuenta {
    private String tipoCuenta;
    private long saldoInicial;
    private long estado;
    private String idCliente;

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String value) {
        this.tipoCuenta = value;
    }

    public long getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(long value) {
        this.saldoInicial = value;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long value) {
        this.estado = value;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String value) {
        this.idCliente = value;
    }
}
