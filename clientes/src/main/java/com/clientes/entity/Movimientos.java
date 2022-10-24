package com.clientes.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Movimientos {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmovimientos")
    private Integer idmovimientos;
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Basic
    @Column(name = "valor")
    private Long valor;
    @Basic
    @Column(name = "saldo")
    private Long saldo;
    @Basic
    @Column(name = "cuenta_idcuenta")
    private Integer cuentaIdcuenta;

    public Integer getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(Integer idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public Integer getCuentaIdcuenta() {
        return cuentaIdcuenta;
    }

    public void setCuentaIdcuenta(Integer cuentaIdcuenta) {
        this.cuentaIdcuenta = cuentaIdcuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimientos that = (Movimientos) o;
        return Objects.equals(idmovimientos, that.idmovimientos) && Objects.equals(fecha, that.fecha) && Objects.equals(tipoMovimiento, that.tipoMovimiento) && Objects.equals(valor, that.valor) && Objects.equals(saldo, that.saldo) && Objects.equals(cuentaIdcuenta, that.cuentaIdcuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmovimientos, fecha, tipoMovimiento, valor, saldo, cuentaIdcuenta);
    }
}
