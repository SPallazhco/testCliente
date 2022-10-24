package com.clientes;

import com.clientes.entity.Cliente;
import com.clientes.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClientesApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	ClienteService clienteService;

	@Test
	void contextLoads() {
	}

	@Test
	public void dadoUnIdRetornaUnCliente() throws Exception {
		Cliente cliente = new Cliente();
		cliente.setIdcliente(1);
		cliente.setPersonaIdpersona("0105480198");
		cliente.setEstado((byte) 0);
		cliente.setContraseña("123");

		ResultActions response = mockMvc.perform(get("/cliente/getCliente/{id}", cliente.getPersonaIdpersona()));
		response.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.contraseña", is(cliente.getContraseña())))
				.andExpect(jsonPath("$.personaIdpersona", is(cliente.getPersonaIdpersona())));
	}

	@Test
	public void dadoDosFechasRetornarMovimientos() throws Exception {
		ResultActions response = mockMvc.perform(get("/cliente/getMovimientosFechas/2020-03-20/2020-03-26"));
		response.andExpect(status().isOk())
				.andDo(print());
	}



}
