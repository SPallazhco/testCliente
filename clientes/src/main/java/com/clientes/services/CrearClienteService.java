package com.clientes.services;

import com.clientes.dao.ClienteDao;
import com.clientes.dao.PersonaDao;
import com.clientes.entity.Cliente;
import com.clientes.entity.Persona;
import com.clientes.models.PersonaCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

@Service
@Slf4j
public class CrearClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    PersonaDao personaDao;
    private Gson json;
    PersonaCliente personaCliente;


    public PersonaCliente crearCliente(String infoCliente) {

        try {
            json =new Gson();
            log.info(infoCliente);
            personaCliente = json.fromJson(infoCliente, PersonaCliente.class);
            log.info(personaCliente.getTbl().getIdpersona());
            Persona persona = new Persona();
            persona.setDireccion(personaCliente.getTbl().getDireccion());
            persona.setEdad(Integer.valueOf(personaCliente.getTbl().getEdad()));
            persona.setGenero(personaCliente.getTbl().getGenero());
            persona.setIdpersona(personaCliente.getTbl().getIdpersona());
            persona.setNombre(personaCliente.getTbl().getNombre());
            persona.setTelefono(Integer.valueOf(personaCliente.getTbl().getTelefono()));
            personaDao.savePersona(persona);
            Cliente cliente = new Cliente();
            cliente.setContraseña(personaCliente.getTbl().getPassword());
            cliente.setEstado((byte) personaCliente.getTbl().getEstado());
            cliente.setPersonaIdpersona(personaCliente.getTbl().getIdpersona());
            clienteDao.saveCliente(cliente);
            personaCliente.setCodigoRespuesta("000");
            personaCliente.setMensajeUsuario("CLIENTE GENERADO EXITOSAMENTE");

        } catch (Exception e) {
         personaCliente.setCodigoRespuesta("003");
         personaCliente.setMensajeUsuario("ERROR AL CREAR EL CLIENTE");
         personaCliente.setMensajeTecnico(e.toString());
        }
        return personaCliente;
    }
}
