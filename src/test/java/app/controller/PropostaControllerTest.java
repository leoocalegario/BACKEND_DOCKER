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

import app.entity.Proposta;
import app.repository.PropostaRepository;

@SpringBootTest
public class PropostaControllerTest {
/*
	@Autowired
	PropostaController propostaController;

	@MockBean
	PropostaRepository repository;

	@BeforeEach
	void setup() {
		List<Proposta> proposta = new ArrayList<>();
		proposta.add(new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null));
		proposta.add(new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null));
		Proposta propostaSalva = new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null);

		when(this.repository.save(any(Proposta.class))).thenReturn(propostaSalva);
		when(this.repository.findAll()).thenReturn(proposta);
		when(this.repository.findByvalorProposta(23456.78)).thenReturn(proposta);
		when(this.repository.findBydataCriado("2023-12-31")).thenReturn(proposta);
		when(this.repository.findById(1L)).thenReturn(Optional.of(propostaSalva));
		doNothing().when(this.repository).deleteById(any(Long.class));
	}
	// ------------------------ Save -----------------------------

	@Test
	@DisplayName("1 -[TESTE] Save")
	void save() {
		Proposta novaproposta = new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null);

		when(repository.save(any(Proposta.class))).thenReturn(novaproposta);
		ResponseEntity<String> PropostaSalva = propostaController.save(novaproposta);
		verify(repository, times(1)).save(novaproposta);
		assertNotNull(PropostaSalva);

	}

	@Test
	@DisplayName("1 -[Exception] Save")
	void save_Exception() {
		when(repository.save(any(Proposta.class))).thenThrow(new RuntimeException("Erro ao Salvar proposta"));
		ResponseEntity<String> response = propostaController
				.save(new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// -------------------------- LIST ALL -----------------------------------

	@Test
	@DisplayName("2 -[TESTE] FindAll")
	void findall() {
		ResponseEntity<List<Proposta>> response = this.propostaController.findAll();
		List<Proposta> propostaAll = response.getBody();

		assertEquals(2, propostaAll.size());
	}

	@Test
	@DisplayName("2 -[EXCEPTION] FindAll")
	void findall_exception() {
		when(this.repository.findAll()).thenThrow(new RuntimeException("Erro ao lista Proposta"));
		ResponseEntity<List<Proposta>> response = this.propostaController.findAll();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}

	// -------------------------------- DELETE
	// -----------------------------------------

	@Test
	@DisplayName("3 -[TESTE] Delete")
	void delete() {
		ResponseEntity<String> response = this.propostaController.delete(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	@DisplayName("3 -[EXCEPTION] Delete")
	void delete_exception() {
		when(propostaController.delete(999L)).thenThrow(new RuntimeException("Erro ao deletar proposta"));
		ResponseEntity<String> response = propostaController.delete(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// ---------------------------- FindById ---------------------------------------

	@Test
	@DisplayName("4 -[TESTE] FindById")
	void FindById() {
		Proposta proposta = new Proposta();
		proposta.setIdProposta(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(proposta));
		ResponseEntity<Proposta> response = propostaController.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(proposta, response.getBody());
	}

	@Test
	@DisplayName("[EXCEPTION] FindById")
	void findById_Exception() {
		when(repository.findById(999L)).thenThrow(new RuntimeException("Erro ao buscar venda"));
		ResponseEntity<Proposta> response = propostaController.findById(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}

	// ---------------------------- UPDATE
	// ---------------------------------------------

	@Test
	@DisplayName("[TESTE] Update")
	void update() {
		Proposta propostaSalva = new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null);
		ResponseEntity<String> response = this.propostaController.update(1L, propostaSalva);
		HttpStatusCode resposta = response.getStatusCode();
		assertEquals(HttpStatus.OK, resposta);
	}

	@Test
	@DisplayName("[EXCEPTION] Update")
	void update_exception() {
		when(this.repository.save(any(Proposta.class))).thenThrow(new RuntimeException("Erro ao Atualizar Proposta"));
		ResponseEntity<String> response = this.propostaController.update(1L,
				new Proposta(1L, "2023-12-31", 23456.78, "Carrao", null, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	// ----------------------------- FindByValorProposta ---------------------------

	@Test
	@DisplayName("[TESTE] FindByValorProposta")
	void findByValorProposta() {
		ResponseEntity<List<Proposta>> response = this.propostaController.findByvalorProposta(23456.78);
		List<Proposta> proposta = response.getBody();
		assertEquals(2, proposta.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// ----------------------------- FindByDataCriada
	// ----------------------------------
	@Test
	@DisplayName("[TESTE] FindByDataCriada")
	void findByDataCriada() {
		ResponseEntity<List<Proposta>> response = this.propostaController.findBydataCriada("2023-12-31");
		List<Proposta> proposta = response.getBody();
		assertEquals(2, proposta.size());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	// -------------------------- VerificarValor ------------------------------

	@Test
	@DisplayName("[TESTE] VerificarValor")
	void verificarvalor() {
		Proposta proposta = new Proposta();
		proposta.setValorProposta(6000);
	
	}*/
}