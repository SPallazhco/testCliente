package com.clientes.models;

public class MovimientosModel {
    private TblMovimientos tblMovimientos;
    private String codigoRespuesta;
    private String mensajeUsuario;
    private String mensajeTecnico;

    public TblMovimientos getTblMovimientos() { return tblMovimientos; }
    public void setTblMovimientos(TblMovimientos value) { this.tblMovimientos = value; }

    public String getCodigoRespuesta() { return codigoRespuesta; }
    public void setCodigoRespuesta(String value) { this.codigoRespuesta = value; }

    public String getMensajeUsuario() { return mensajeUsuario; }
    public void setMensajeUsuario(String value) { this.mensajeUsuario = value; }

    public String getMensajeTecnico() { return mensajeTecnico; }
    public void setMensajeTecnico(String value) { this.mensajeTecnico = value; }
}

