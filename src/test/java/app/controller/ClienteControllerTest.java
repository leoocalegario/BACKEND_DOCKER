package app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@SpringBootTest
public class ClienteControllerTest {
/*
	@Autowired
	ClienteController clienteController;

	@MockBean
	ClienteRepository repository;

	@BeforeEach
	void setup() {

		List<Cliente> cliente = new ArrayList<>();
		cliente.add(new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24, "Rua Araguaia",
				"Foz do Iguaçu", "Parana", "10-03-2022", true, true, null));

		Cliente clienteSalva = new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24,
				"Rua Araguaia", "Foz do Iguaçu", "Parana", "10-03-2022", true, true, null);

		when(this.repository.save(any(Cliente.class))).thenReturn(clienteSalva);
		when(this.repository.findAll()).thenReturn(cliente);
		when(this.repository.findByNomeLike("LEONARDO")).thenReturn(cliente);
		when(this.repository.findByNome("LEONARDO")).thenReturn(cliente);
		when(this.repository.findByCidade("Foz do Iguaçu")).thenReturn(cliente);
		when(this.repository.findById(1L)).thenReturn(Optional.of(clienteSalva));
		doNothing().when(this.repository).deleteById(any(Long.class));

	}

	// ------------------------ Save -----------------------------

	@Test
	@DisplayName("1 -[TESTE] Save")
	void save() {
		Cliente novoCliente = new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24,
				"Rua Araguaia", "Foz do Iguaçu", "Parana", "10-03-2022", true, true, null);

		when(repository.save(any(Cliente.class))).thenReturn(novoCliente);
		ResponseEntity<String> ClienteSalva = clienteController.save(novoCliente);
		verify(repository, times(1)).save(novoCliente);
		assertNotNull(ClienteSalva);

	}

	@Test
	@DisplayName("1 -[Exception] Save")
	void save_Exception() {
		when(repository.save(any(Cliente.class))).thenThrow(new RuntimeException("Erro ao Salvar a Vendedor"));
		ResponseEntity<String> response = clienteController
				.save(new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24, "Rua Araguaia",
						"Foz do Iguaçu", "Parana", "10-03-2022", true, true, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// -------------------------- LIST ALL -----------------------------------

	@Test
	@DisplayName("2 -[TESTE] findAll")
	void findall() {
		ResponseEntity<List<Cliente>> response = this.clienteController.findAll();
		List<Cliente> clienteAll = response.getBody();

		assertEquals(1, clienteAll.size());
	}

	@Test
	@DisplayName("2 -[EXCEPTION] FindAll")
	void findall_exception() {
		when(this.repository.findAll()).thenThrow(new RuntimeException("Erro ao listar Cliente"));
		ResponseEntity<List<Cliente>> response = this.clienteController.findAll();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}

	// -------------------------------- DELETE
	// -----------------------------------------

	@Test
	@DisplayName("3 -[TESTE] Delete")
	void delete() {
		ResponseEntity<String> response = this.clienteController.delete(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("3 -[EXCEPTION] Delete")
	void delete_exception() {
		when(clienteController.delete(999L)).thenThrow(new RuntimeException("Erro ao deletar cliente"));
		ResponseEntity<String> response = clienteController.delete(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// ---------------------------- FindById ---------------------------------------

	@Test
	@DisplayName("4 -[TESTE] FindById")
	void FindById() {
		Cliente cliente = new Cliente();
		cliente.setIdUser(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(cliente));
		ResponseEntity<Cliente> response = clienteController.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(cliente, response.getBody());
	}

	@Test
	@DisplayName("[EXCEPTION] FindById")
	void findById_Exception() {
		when(repository.findById(999L)).thenThrow(new RuntimeException("Erro ao buscar cliente"));
		ResponseEntity<Cliente> response = clienteController.findById(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}

	// ---------------------------- UPDATE
	// ---------------------------------------------

	@Test
	@DisplayName("[TESTE] Update")
	void update() {
		Cliente clienteSalva = new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24,
				"Rua Araguaia", "Foz do Iguaçu", "Parana", "10-03-2022", true, true, null);
		ResponseEntity<String> response = this.clienteController.update(1L, clienteSalva);
		HttpStatusCode resposta = response.getStatusCode();
		assertEquals(HttpStatus.OK, resposta);
	}

	@Test
	@DisplayName("[EXCEPTION] Update")
	void update_exception() {
		when(this.repository.save(any(Cliente.class))).thenThrow(new RuntimeException("Erro ao Atualizar Cliente"));
		ResponseEntity<String> response = this.clienteController.update(1L,
				new Cliente(1L, "123456", "leo@hotmail.com", "LEONARDO", "(45)999858834", 24, "Rua Araguaia",
						"Foz do Iguaçu", "Parana", "10-03-2022", true, true, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// ----------------------------- FindByNome ----------------------------------
	@Test
	@DisplayName("[TESTE] FindByNome")
	void findByNome() {
		ResponseEntity<List<Cliente>> response = this.clienteController.findByNome("LEONARDO");
		List<Cliente> cliente = response.getBody();
		assertEquals(1, cliente.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// ----------------------------- FindByNomeLike
	// ----------------------------------
	@Test
	@DisplayName("[TESTE] FindByNomeLike")
	void findByNomeLike() {
		ResponseEntity<List<Cliente>> response = this.clienteController.findByNomeLike("LEONARDO");
		List<Cliente> cliente = response.getBody();
		assertEquals(1, cliente.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// ----------------------------- FindByDataCidade
	// ----------------------------------
	@Test
	@DisplayName("[TESTE] FindByCidade")
	void findByCidade() {
		ResponseEntity<List<Cliente>> response = this.clienteController.findByCidade("Foz do Iguaçu");
		List<Cliente> cliente = response.getBody();
		assertEquals(1, cliente.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
*/
	}
