package com.clientes.models;

public class TblMovimientos {
    private String fecha;
    private String tipoMovimiento;
    private String valor;
    private String saldo;
    private String idCuenta;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String value) {
        this.fecha = value;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String value) {
        this.tipoMovimiento = value;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String value) {
        this.valor = value;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String value) {
        this.saldo = value;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String value) {
        this.idCuenta = value;
    }
}
