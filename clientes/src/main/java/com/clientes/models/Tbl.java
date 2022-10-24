package com.clientes.models;

public class Tbl {
    private String password;
    private long estado;
    private String idpersona;
    private String nombre;
    private String genero;
    private String edad;
    private String direccion;
    private String telefono;

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }

    public long getEstado() {
        return estado;
    }

    public void setEstado(long value) {
        this.estado = value;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String value) {
        this.idpersona = value;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String value) {
        this.nombre = value;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String value) {
        this.genero = value;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String value) {
        this.edad = value;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String value) {
        this.direccion = value;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String value) {
        this.telefono = value;
    }
}
