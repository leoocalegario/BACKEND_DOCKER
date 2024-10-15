package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.VeiculosMarca;
import app.repository.VeiculosMarcaRepository;

@Service
public class VeiculosMarcaService {

	@Autowired
	private VeiculosMarcaRepository veiculosmarcarepository;
	
	@Autowired
	private LogService logService;

	public String save(VeiculosMarca veiculosmarca) {

		this.veiculosmarcarepository.save(veiculosmarca);
		logService.createLog("SAVE", veiculosmarca.getMarca(),"Marca");
		return veiculosmarca.getMarca() + " salvo com sucesso";

	}

	public String update(Long idMarca, VeiculosMarca veiculosmarca) {
		veiculosmarca.setIdMarca(idMarca);
		this.veiculosmarcarepository.save(veiculosmarca);
		
		logService.createLog("UPDATE", veiculosmarca.getMarca(),"Marca");
		return veiculosmarca.getMarca() + "atualizado com sucesso";
	}

	public String delete(Long idMarca) {
		VeiculosMarca veiculosmarca = this.veiculosmarcarepository.findByIdMarca(idMarca);
		logService.createLog("DELETE", veiculosmarca.getMarca(),"Marca");
		this.veiculosmarcarepository.deleteById(idMarca);
		return "Marca deletada com sucesso";
	}

	public List<VeiculosMarca> findAll() {
		return this.veiculosmarcarepository.findAll();
	}

	public VeiculosMarca findById(Long id) {
		VeiculosMarca veiculosmarca = this.veiculosmarcarepository.findById(id).get();
		return veiculosmarca;
	}

	public VeiculosMarca findByMarca(String marca) {
		VeiculosMarca veiculosMarca = veiculosmarcarepository.findByMarca(marca);
		return veiculosMarca;
	}

}
