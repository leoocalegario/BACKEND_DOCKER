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

import app.entity.Vendedores;
import app.service.VendedoresService;

@RestController
@RequestMapping("/api/vendedores")
@CrossOrigin("*")
@Validated
public class VendedoresController {

	@Autowired
	private VendedoresService vendedoresservice;
	@PreAuthorize("hasRole(1) or hasRole(2)")	
	//funcao para salvar cadastro do vendedor
	@PostMapping("save")
	public ResponseEntity<String> save(@RequestBody Vendedores vendedores) {
		try {
			String mensagem = this.vendedoresservice.save(vendedores);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	//funcao para fazer uma atualizacao no cadastro do vendedor
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/update/{idVendedor}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Vendedores vendedores) {
		try {
			String mensagem = this.vendedoresservice.update(id, vendedores);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
		//funcao para mostrar todos os cadastros de vendedores
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/listAll")
	public ResponseEntity<List<Vendedores>> findAll() {
		try {
			List<Vendedores> lista = this.vendedoresservice.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}
		//funcao para procurar vendedor pelo idVendedor
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findById/{idVendedor}")
	public ResponseEntity<Vendedores> findById(@PathVariable Long idVendedor) {
		try {
			Vendedores vendedores = this.vendedoresservice.findById(idVendedor);
			return new ResponseEntity<>(vendedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
		//funcao para excluir o id do vendedor
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@DeleteMapping("/delete/{idVendedor}")
	public ResponseEntity<String> delete(@PathVariable Long idVendedor) {
		try {

			String mensagem = this.vendedoresservice.delete(idVendedor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("Ocorreu esse erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
		//funcao para procurar vendedor por nome
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findByNomeLike")
	public ResponseEntity<List<Vendedores>> findByNomeLike(@RequestParam String nome) {
		try {

			List<Vendedores> lista = this.vendedoresservice.findByNomeLike(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
		//funcao para procurar vendedor por email
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@GetMapping("/findByEmail")
	public ResponseEntity<Vendedores> findByEmail(@RequestParam String email) {
		try {

			Vendedores vendedores = this.vendedoresservice.findByEmail(email);
			return new ResponseEntity<>(vendedores, HttpStatus.OK);
			//

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
}
