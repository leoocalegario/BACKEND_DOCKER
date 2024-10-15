package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Proposta;
import app.service.PropostaService;
import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/api/proposta")
public class PropostaController {

	@Autowired
	private PropostaService propostaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody @Valid Proposta proposta) {
		try {
			String mensagem = this.propostaService.save(proposta);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		try {
			String mensagem = this.propostaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu esse erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findById/{id}")
	public ResponseEntity<Proposta> findById(@PathVariable Long id) {
		try {
			Proposta proposta = this.propostaService.findById(id);
			return new ResponseEntity<>(proposta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/listAll")
	public ResponseEntity<List<Proposta>> findAll() {
		try {
			List<Proposta> proposta = this.propostaService.listAll();
			return new ResponseEntity<>(proposta, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid Proposta proposta) {
		try {
			String mensagem = this.propostaService.update(proposta, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findByValorProposta")
	public ResponseEntity<List<Proposta>> findByvalorProposta(@RequestParam double valorProposta) {
		try {
			List<Proposta> lista = this.propostaService.findByvalorProposta(valorProposta);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
