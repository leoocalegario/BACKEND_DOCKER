package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.AnuncioVeiculo;
import app.service.AnuncioVeiculoService;

@RestController
@RequestMapping("/api/anuncioveiculo")
@CrossOrigin("*")
@Validated
public class AnuncioVeiculoController {
	
	@Autowired
	private AnuncioVeiculoService anuncioveiculoservice;
	
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PostMapping("save")
	public ResponseEntity<String> save ( @RequestBody AnuncioVeiculo anuncioveiculo){
		try {
			String mensagem = this.anuncioveiculoservice.save(anuncioveiculo);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("erro: " +e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/update/{id}")
	public ResponseEntity<String>update ( @PathVariable Long id, @RequestBody AnuncioVeiculo anuncioveiculo){
		try {
			String mensagem = this.anuncioveiculoservice.update(id, anuncioveiculo);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());

			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<AnuncioVeiculo>>findAll(){
		try {
			List<AnuncioVeiculo> lista = this.anuncioveiculoservice.findAll();
			return new ResponseEntity<>(lista,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
			
		}
	}
	
	@GetMapping("/findById/{idAnuncio}")
	public ResponseEntity<AnuncioVeiculo> findById(@PathVariable Long idAnuncio){
		try {
			AnuncioVeiculo anuncioveiculo = this.anuncioveiculoservice.findById(idAnuncio);
			return new ResponseEntity<>(anuncioveiculo,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@DeleteMapping("/delete/{idAnuncio}")
	public ResponseEntity<String> delete(@PathVariable Long idAnuncio) {

		try {

			String mensagem = this.anuncioveiculoservice.delete(idAnuncio);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/findByModeloLike")
	public ResponseEntity<List<AnuncioVeiculo>> findByModeloLike(@RequestParam("modelo") String modelo) {
	    try {
	        List<AnuncioVeiculo> anuncioveiculo = this.anuncioveiculoservice.findByModeloLike(modelo);
	        return new ResponseEntity<>(anuncioveiculo, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
	}


}