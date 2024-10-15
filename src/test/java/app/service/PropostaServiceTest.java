package app.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import app.entity.Proposta;
import app.repository.PropostaRepository;

@SpringBootTest
public class PropostaServiceTest {
	/*
	@Autowired
	PropostaService	propostaService;
	
	@MockBean
	PropostaRepository repositry;
	
	@Test
	@DisplayName("[TESTE] VerificarValor")
	void verificarvalor() {
		Proposta proposta = new Proposta();
		proposta.setValorProposta(6000);
		propostaService.verificarValor(proposta);
	}
	
	@Test
	@DisplayName("[EXCEPTION] VerificarValor")
	void verificarvalor_exception() {
		Proposta proposta = new Proposta();
		proposta.setValorProposta(4000);
		assertThrows(RuntimeException.class, () -> propostaService.verificarValor(proposta));
	}
	*/
}