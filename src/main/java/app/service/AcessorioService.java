package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	@Autowired
	private LogService logService;
	
	
	public String save(Acessorio acessorio) {
		this.acessorioRepository.save(acessorio);
		logService.createLog("SAVE", acessorio.getNome(),"Acessorio");
		return acessorio.getNome()+ "Salvo com sucesso";
	}
	
	public String update(long id, Acessorio acessorio) {
		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		logService.createLog("UPDATE", acessorio.getNome(),"Acessorio");
		return acessorio.getNome() + "Atualizado com Sucesso";
	}
	
	public List<Acessorio> listAll(){
		return this.acessorioRepository.findAll();
	}
	
	public Acessorio findById(long id) {
		Acessorio acessorio = this.acessorioRepository.findById(id).get();
		return acessorio;
	}
	
	public String delete(long id) {
		Acessorio acessorio = this.acessorioRepository.findById(id).get();
		String nome = acessorio.getNome();
		logService.createLog("DELETE", nome,"Acessorio");
		this.acessorioRepository.deleteById(id);
		return "Acessorio Deletado";
	}
}
