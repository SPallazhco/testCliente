package com.clientes.models;

public class CuentaModel {
    private TblCuenta tblCuenta;
    private String codigoRespuesta;
    private String mensajeUsuario;
    private String mensajeTecnico;

    public TblCuenta getTblCuenta() { return tblCuenta; }
    public void setTblCuenta(TblCuenta value) { this.tblCuenta = value; }

    public String getCodigoRespuesta() { return codigoRespuesta; }
    public void setCodigoRespuesta(String value) { this.codigoRespuesta = value; }

    public String getMensajeUsuario() { return mensajeUsuario; }
    public void setMensajeUsuario(String value) { this.mensajeUsuario = value; }

    public String getMensajeTecnico() { return mensajeTecnico; }
    public void setMensajeTecnico(String value) { this.mensajeTecnico = value; }
}


