package com.clientes.models;

public class PersonaCliente {
    private Tbl tbl;
    private String codigoRespuesta;
    private String mensajeUsuario;
    private String mensajeTecnico;

    public Tbl getTbl() { return tbl; }
    public void setTbl(Tbl value) { this.tbl = value; }

    public String getCodigoRespuesta() { return codigoRespuesta; }
    public void setCodigoRespuesta(String value) { this.codigoRespuesta = value; }

    public String getMensajeUsuario() { return mensajeUsuario; }
    public void setMensajeUsuario(String value) { this.mensajeUsuario = value; }

    public String getMensajeTecnico() { return mensajeTecnico; }
    public void setMensajeTecnico(String value) { this.mensajeTecnico = value; }
}