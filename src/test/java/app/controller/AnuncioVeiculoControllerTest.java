//package app.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//
//import app.entity.AnuncioVeiculo;
//import app.repository.AnuncioVeiculoRepository;
//
//@SpringBootTest
//public class AnuncioVeiculoControllerTest {
///*
//	@Autowired
//	AnuncioVeiculoController anuncioVeiculoController;
//
//	@MockBean
//	AnuncioVeiculoRepository repository;
///*
//	@BeforeEach
//	void setup() {
//		List<AnuncioVeiculo> anuncios = new ArrayList<>();
//		anuncios.add(new AnuncioVeiculo(1L, "2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true, true,
//				"Automático", 50000.0, "ABC1234", 0, null, null, null));
//
//		
//		AnuncioVeiculo anuncio = new AnuncioVeiculo(1L, "2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true,
//				true, "Automático", 50000.0, "ABC1234", 0, null, null, null);
//
//		when(this.repository.save(any(AnuncioVeiculo.class))).thenReturn(anuncio);
//		when(this.repository.findAll()).thenReturn(anuncios);
//		when(this.repository.findByNomeVeiculoLike("Carro")).thenReturn(anuncios);
//		when(this.repository.findById(1L)).thenReturn(Optional.of(anuncio));
//		doNothing().when(this.repository).deleteById(any(Long.class));
//		
//	}*/
///*
//	@Test
//	@DisplayName("1 -[TESTE] Save")
//	void save() {
//		AnuncioVeiculo anuncio = new AnuncioVeiculo(1L, "2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true, true, "Automático", 50000.0, "ABC1234", 0, null, null, null);
//
//		when(repository.save(any(AnuncioVeiculo.class))).thenReturn(anuncio);
//		ResponseEntity<String> AnuncioVeiculoSalva = anuncioVeiculoController.save(anuncio);
//		verify(repository, times(1)).save(anuncio);
//		assertNotNull(AnuncioVeiculoSalva);
//	}
//*//*
//	@Test
//	@DisplayName("1 -[Exception] Save")
//	void save_Exception() {
//		when(repository.save(any(AnuncioVeiculo.class))).thenThrow(new RuntimeException("Erro ao Salvar a Anuncio"));
//		ResponseEntity<String> response = anuncioVeiculoController.save(new AnuncioVeiculo(1L, "2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true, true, "Automático", 50000.0, "ABC1234", 0, null, null, null));
//		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//	}
//	*/
//	/*
//	@Test
//	@DisplayName("2 -[TESTE] findAll")
//	void findall() {
//		ResponseEntity<List<AnuncioVeiculo>> response = this.anuncioVeiculoController.findAll();
//		List<AnuncioVeiculo> AnuncioVeiculoAll = response.getBody();
//		
//		assertEquals(1, AnuncioVeiculoAll.size());
//	}
//	
//	@Test
//	@DisplayName("2 -[EXCEPTION] FindAll")
//	void findall_exception() {
//		when(this.repository.findAll()).thenThrow(new RuntimeException("Erro ao lista Marca"));
//		ResponseEntity<List<AnuncioVeiculo>> response = this.anuncioVeiculoController.findAll();
//		assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//		assertNull(response.getBody());
//	}
//	
//	@Test
//	@DisplayName("3 -[TESTE] Delete")
//	void delete() {
//		ResponseEntity<String> response = this.anuncioVeiculoController.delete(1L);
//		assertEquals(HttpStatus.OK,response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("3 -[EXCEPTION] Delete")
//	void delete_exception() {
//		when(anuncioVeiculoController.delete(999L)).thenThrow(new RuntimeException("Erro ao deletar proposta"));
//		ResponseEntity<String> response = anuncioVeiculoController.delete(999L);
//		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//	}
//	
//	@Test
//	@DisplayName("4 -[TESTE] FindById")
//	void FindById() {
//		AnuncioVeiculo anuncioveiculo = new AnuncioVeiculo();
//		anuncioveiculo.setIdAnuncio(1L);
//		when(repository.findById(1L)).thenReturn(Optional.of(anuncioveiculo));
//		ResponseEntity<AnuncioVeiculo> response = anuncioVeiculoController.findById(1L);
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(anuncioveiculo,response.getBody());
//	}
//	
//	@Test
//	@DisplayName("[EXCEPTION] FindById")
//	void findById_Exception() {
//		when(repository.findById(999L)).thenThrow(new RuntimeException("Erro ao buscar venda"));
//		ResponseEntity<AnuncioVeiculo> response = anuncioVeiculoController.findById(999L);
//		assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//		assertNull(response.getBody());
//	}
//	*/
//	/*
//	@Test
//	@DisplayName("[TESTE] Update")
//	void update() {
//	    AnuncioVeiculo anuncioveiculosalva = new AnuncioVeiculo(1L, "2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true, true, "Automático", 50000.0, "ABC1234", 0, null, null, null);
//	    ResponseEntity<String> response = this.anuncioVeiculoController.update(1L,anuncioveiculosalva);
//	    HttpStatusCode resposta = response.getStatusCode();
//	    assertEquals(HttpStatus.OK, resposta);
//	}
//	
//	@Test
//	@DisplayName("[EXCEPTION] Update")
//	void update_exception() {
//		when(this.repository.save(any(AnuncioVeiculo.class))).thenThrow(new RuntimeException("Erro ao Atualizar Anuncio"));
//		ResponseEntity<String> response = this.anuncioVeiculoController.update(1L,new AnuncioVeiculo(1L,"2022-04-17", "Carro", "Preto", "Modelo X", 2022, 1, true, true, true, "Automático", 50000.0, "ABC1234", 0, null, null, null));
//		assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
//	}
//	*/
//	//----------------------------		FindByMarca		---------------------------------------
//	/*
//	@Test
//	@DisplayName("[TESTE] findByNomeVeiculoLike")
//	void findByNomeVeiculoLike() {
//		ResponseEntity<List<AnuncioVeiculo>> response = this.anuncioVeiculoController.findByNomeVeiculoLike("Carro");
//		List<AnuncioVeiculo> anuncioveiculo = response.getBody();
//		assertEquals(1, anuncioveiculo.size());
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//	}
//	*/
//}
