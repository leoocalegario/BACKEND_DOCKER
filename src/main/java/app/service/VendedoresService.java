package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Vendedores;
import app.repository.VendedoresRepository;

@Service
public class VendedoresService {
	@Autowired
	private VendedoresRepository vendedoresrepository;

	public String save(Vendedores vendedores) {

		this.vendedoresrepository.save(vendedores);
		return vendedores.getNome() + "salvo com sucesso";

	}
	
	public String update(Long id, Vendedores vendedores) {
		vendedores.setIdVendedor(id);
		this.vendedoresrepository.save(vendedores);
		return vendedores.getNome() + "atualizado com sucesso";
	}

	public String delete(Long idVendedor) {
		this.vendedoresrepository.deleteById(idVendedor);
		return "Vendedor deletado com sucesso";
	}

	public List<Vendedores> findAll() {
		return this.vendedoresrepository.findAll();
	}

	public Vendedores findById(Long id) {
		Vendedores vendedores = this.vendedoresrepository.findById(id).get();
		return vendedores;
	}

	public List<Vendedores> findByNomeLike(String nome) {
		return this.vendedoresrepository.findByNomeLike(nome);

	}

	public Vendedores findByEmail(String email) {

		Vendedores vendedores = this.vendedoresrepository.findByEmail(email).get();
		return vendedores;
	}

}
