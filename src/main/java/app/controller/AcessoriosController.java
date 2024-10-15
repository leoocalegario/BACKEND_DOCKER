package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Acessorio;
import app.service.AcessorioService;

@RestController
@RequestMapping("/api/acessorio")
@CrossOrigin("*")
public class AcessoriosController {
	@Autowired
	private AcessorioService acessorioService;
	
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Acessorio acessorio) {
		
		try {
			
			String mensagem = this.acessorioService.save(acessorio);
			return new ResponseEntity<String>(mensagem, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable long id) {
		
		try {
			
			String mensagem = this.acessorioService.update(id, acessorio);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			
		}
		
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/listAll")
	public ResponseEntity<List<Acessorio>> listAll (){
		
		try {
			
			List<Acessorio> lista = this.acessorioService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findById/{idAcessorio}")
	public ResponseEntity<Acessorio> findById(@PathVariable long idAcessorio){
		
		try {
			
			Acessorio acessorio = this.acessorioService.findById(idAcessorio);
			return new ResponseEntity<>(acessorio, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@DeleteMapping("/delete/{idAcessorio}")
	public ResponseEntity<String> delete(@PathVariable long idAcessorio){
		
		try {
			
			String mensagem = this.acessorioService.delete(idAcessorio);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
