package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.AnuncioVeiculo;
import app.repository.AnuncioVeiculoRepository;

@Service
public class AnuncioVeiculoService {

	@Autowired
	private AnuncioVeiculoRepository anuncioveiculorepository;

	@Autowired
	private LogService logService;
	
	public String save(AnuncioVeiculo anuncioveiculo) {

		this.anuncioveiculorepository.save(anuncioveiculo);
	    String detalhesVeiculo = "ID: " + anuncioveiculo.getIdAnuncio() + ", "
                + "Modelo: " + anuncioveiculo.getModelo() + ", "
                + "Cor: " + anuncioveiculo.getCor() + ", "
                + "Ano: " + anuncioveiculo.getAno() + ", "
                + "Combustível: " + anuncioveiculo.getCombustivel() + ", "
                + "Valor: R$" + anuncioveiculo.getValorcarro() + ", "
                + "Placa: " + anuncioveiculo.getPlacacarro() + ", "
                + "Km: " + anuncioveiculo.getKm() + ", "
                + "Imagem: " + anuncioveiculo.getImagem();
		logService.createLog("SAVE", detalhesVeiculo,"Veiculo");
		return anuncioveiculo.getModelo() + " salvo com sucesso";
	}

	public String update(Long id, AnuncioVeiculo anuncioveiculo) {
		anuncioveiculo.setIdAnuncio(id);
		this.anuncioveiculorepository.save(anuncioveiculo);
		String detalhesVeiculo = "ID: " + anuncioveiculo.getIdAnuncio() + ", "
                + "Modelo: " + anuncioveiculo.getModelo() + ", "
                + "Cor: " + anuncioveiculo.getCor() + ", "
                + "Ano: " + anuncioveiculo.getAno() + ", "
                + "Combustível: " + anuncioveiculo.getCombustivel() + ", "
                + "Valor: R$" + anuncioveiculo.getValorcarro() + ", "
                + "Placa: " + anuncioveiculo.getPlacacarro() + ", "
                + "Km: " + anuncioveiculo.getKm() + ", "
                + "Imagem: " + anuncioveiculo.getImagem();
		logService.createLog("UPDATE", detalhesVeiculo,"Veiculo");
		return anuncioveiculo.getModelo() + "atualizado com sucesso";
	}

	public String delete(Long idAnuncio) {
		AnuncioVeiculo anuncioveiculo = this.anuncioveiculorepository.findById(idAnuncio).get();
		String nome = anuncioveiculo.getModelo();
		String detalhesVeiculo = "ID: " + anuncioveiculo.getIdAnuncio() + ", "
                + "Modelo: " + anuncioveiculo.getModelo() + ", "
                + "Cor: " + anuncioveiculo.getCor() + ", "
                + "Ano: " + anuncioveiculo.getAno() + ", "
                + "Combustível: " + anuncioveiculo.getCombustivel() + ", "
                + "Valor: R$" + anuncioveiculo.getValorcarro() + ", "
                + "Placa: " + anuncioveiculo.getPlacacarro() + ", "
                + "Km: " + anuncioveiculo.getKm() + ", "
                + "Imagem: " + anuncioveiculo.getImagem();
		this.anuncioveiculorepository.deleteById(idAnuncio);
		logService.createLog("DELETE", detalhesVeiculo,"Veiculo");
		return "Anuncio deletado com sucesso";
	}

	public List<AnuncioVeiculo> findAll() {
		return this.anuncioveiculorepository.findAll();
	}

	public AnuncioVeiculo findById(Long id) {
		AnuncioVeiculo anuncioveiculo = this.anuncioveiculorepository.findById(id).get();
		return anuncioveiculo;
	}

	public List<AnuncioVeiculo> findByModeloLike(String modelo) {
		if(modelo.equals(""))
			return this.findAll();
		
		System.out.println(modelo);
		List<AnuncioVeiculo> anuncioveiculo = anuncioveiculorepository.findByModeloLike(modelo);
		System.out.println(anuncioveiculo.size());
		return anuncioveiculo;
	}

}
