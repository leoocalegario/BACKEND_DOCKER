package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Proposta;
import app.repository.PropostaRepository;

@Service
public class PropostaService {
	@Autowired
	private PropostaRepository propostaRepository;

	public String save(Proposta proposta) {
		this.verificarValor(proposta);
		this.propostaRepository.save(proposta);
		return "Sua proposta foi enviada!";
	}

	public Proposta findById(Long id) {
		Optional<Proposta> proposta = this.propostaRepository.findById(id);
		return proposta.get();
	}

	public List<Proposta> listAll() {
		List<Proposta> proposta = this.propostaRepository.findAll();
		return proposta;
	}

	public String delete(Long id) {
		this.propostaRepository.deleteById(id);
		return "Proposta deletada com sucesso!";
	}

	public String update(Proposta proposta, Long id) {
		proposta.setIdProposta(id);
		this.propostaRepository.save(proposta);
		return "Proposta Atualizada";
	}


	public List<Proposta> findByvalorProposta(double valorProposta) {
		return propostaRepository.findByvalorProposta(valorProposta);
	}

	public void verificarValor(Proposta proposta) {
		if (proposta.getValorProposta() <= 5000) {
			throw new RuntimeException("Não é possivel salvar a proposta menores que R$5000,00 reais");
		}
	}
}