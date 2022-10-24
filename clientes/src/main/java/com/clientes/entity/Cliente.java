package com.clientes.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic
    @Column(name = "contraseña")
    private String contraseña;
    @Basic
    @Column(name = "estado")
    private Byte estado;
    @Basic
    @Column(name = "persona_idpersona")
    private String personaIdpersona;

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Byte getEstado() {
        return estado;
    }

    public void setEstado(Byte estado) {
        this.estado = estado;
    }

    public String getPersonaIdpersona() {
        return personaIdpersona;
    }

    public void setPersonaIdpersona(String personaIdpersona) {
        this.personaIdpersona = personaIdpersona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idcliente, cliente.idcliente) && Objects.equals(contraseña, cliente.contraseña) && Objects.equals(estado, cliente.estado) && Objects.equals(personaIdpersona, cliente.personaIdpersona);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, contraseña, estado, personaIdpersona);
    }
}
