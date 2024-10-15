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

import app.entity.Vendedores;
import app.repository.VendedoresRepository;


@SpringBootTest
public class VendedoresControllerTest {
/*

    @Autowired
    VendedoresController vendedoresController;

    @MockBean
    VendedoresRepository repository;

    // se trata de uma anotation usada nos frameworks de teste para indicar que um metodo deve ser executado antes de cada metodo de testes.
    @BeforeEach
    void setup() {
        List<Vendedores> vendedores = new ArrayList<>();
        vendedores.add(new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null));

        Vendedores vendedoresSalva = new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null);

        when(this.repository.save(any(Vendedores.class))).thenReturn(vendedoresSalva);
        when(this.repository.findAll()).thenReturn(vendedores);
        when(this.repository.findByNomeLike("LEONARDO")).thenReturn(vendedores);
        //when(this.repository.findByEmail("leo@hotmail.com")).thenReturn(vendedoresSalva);
        when(this.repository.findById(1L)).thenReturn(Optional.of(vendedoresSalva));
        doNothing().when(this.repository).deleteById(any(Long.class));
    }
	
	// ------------------------		Save	-----------------------------
	
	@Test
	@DisplayName("1 - [TESTE] Save")
	void save() {
		Vendedores novoVendedores = new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null);
		
		when(repository.save(any(Vendedores.class))).thenThrow(new RuntimeException("Erro ao salvar o Vendedor"));
		ResponseEntity<String> VendedoresSalva = vendedoresController.save(novoVendedores);
		verify(repository, times(1)).save(novoVendedores);
		assertNotNull(VendedoresSalva);
		
	}
	
	@Test
	@DisplayName("1 - [Exception] Save")
	void save_Exception() {
		when(repository.save(any(Vendedores.class))).thenThrow(new RuntimeException("Erro ao salvar o vendedor"));
		ResponseEntity<String> response = vendedoresController.save(new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		
	}
		
		//--------------------------	LIST ALL	-----------------------------------
		
	
	@Test
	@DisplayName("2 - [TESTE] findAll")
	void findall() {
		ResponseEntity<List<Vendedores>> response = this.vendedoresController.findAll();
		List<Vendedores> vendedoresAll = response.getBody();
		
		assertEquals(1, vendedoresAll.size());
	}
	
	@Test
	@DisplayName("2 - [Exception] findAll")
	void findall_exception() {
		when(this.repository.findAll()).thenThrow(new RuntimeException("Erro ao listar Vendedor"));
		ResponseEntity<List<Vendedores>> response = this.vendedoresController.findAll();
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}
		
	
	//--------------------------------	DELETE 	-----------------------------------------
	
	@Test
	@DisplayName("3 - [TESTE] Delete")
	void delete() {
		ResponseEntity<String> response = this.vendedoresController.delete(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	@DisplayName("3 - [EXCEPTION] Delete")
	void delete_exception() {
		when(vendedoresController.delete(999L)).thenThrow(new RuntimeException("Erro ao deletar venda"));
		ResponseEntity<String> response = vendedoresController.delete(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	//----------------------------		FindById		---------------------------------------
	
	@Test
	@DisplayName("4 - [TESTE] FindById")
	void FindById() {
		Vendedores vendedores = new Vendedores();
		vendedores.setIdVendedor(1L);
		when(repository.findById(1L)).thenReturn(Optional.of(vendedores));
		ResponseEntity<Vendedores> response = vendedoresController.findById(1L);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(vendedores, response.getBody());
	}
	
	@Test
	@DisplayName("[EXCEPTION] FindById")
	void findById_Exception() {
		when(repository.findById(999L)).thenThrow(new RuntimeException("Erro ao buscar vendedor"));
		ResponseEntity<Vendedores> response = vendedoresController.findById(999L);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertNull(response.getBody());
	}
	
	//----------------------------		UPDATE		---------------------------------------------
	
	@Test
	@DisplayName("[TESTE] Update")
	void update() {
		Vendedores vendedoresSalva = new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null);
		ResponseEntity<String> response = this.vendedoresController.update(1L, vendedoresSalva);
		HttpStatusCode resposta = response.getStatusCode();
		assertEquals(HttpStatus.OK, resposta);
	}
	
	
	
	@Test
	@DisplayName("[EXCEPTION] Update")
	void update_exception() {
		when(this.repository.save(any(Vendedores.class))).thenThrow(new RuntimeException("Erro ao atualizar vendedor"));
		ResponseEntity<String> response = this.vendedoresController.update(1L, new Vendedores(1L,"123456","leo@hotmail.com","LEONARDO", 24, "Rua Araguaia", "Foz do Iguaçu", "Parana",1, true, null));
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
		
	//----------------------------		FindByNome	---------------------------------------
	
	@Test
	@DisplayName("[TESTE] FindByNomeLike")
    void findByNomeLike() {
        ResponseEntity<List<Vendedores>> response = this.vendedoresController.findByNomeLike("LEONARDO");
        List<Vendedores> vendedores = response.getBody();
        assertEquals(1, vendedores.size());
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	@DisplayName("[TESTE] FindByEmail")
	void findByEmail() {
        ResponseEntity<Vendedores> response = this.vendedoresController.findByEmail("leo@hotmail.com");
        Vendedores vendedores = response.getBody();
        assertNotNull(vendedores);
        assertEquals("leo@hotmail.com", vendedores.getEmail());
        assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	*/
}