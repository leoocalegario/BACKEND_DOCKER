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

import app.entity.VeiculosMarca;
import app.service.VeiculosMarcaService;

@RestController
@RequestMapping("/api/veiculosmarca")
@CrossOrigin("*")
@Validated
public class VeiculosMarcaController {

	@Autowired
	private VeiculosMarcaService veiculosmarcaservice;
	//@PreAuthorize("hasRole(1) or hasRole(2)")
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody VeiculosMarca veiculosmarca) {
//		return new ResponseEntity<String>("sucesso", HttpStatus.OK);
		try {
			String mensagem = this.veiculosmarcaservice.save(veiculosmarca);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id, @RequestBody VeiculosMarca veiculosmarca) {
		try {
			String mensagem = this.veiculosmarcaservice.update(id, veiculosmarca);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<VeiculosMarca>> findAll() {
		try {
			List<VeiculosMarca> lista = this.veiculosmarcaservice.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findById/{idMarca}")
	public ResponseEntity<VeiculosMarca> findById(@PathVariable Long idMarca) {
		try {
			VeiculosMarca veiculosmarca = this.veiculosmarcaservice.findById(idMarca);
			return new ResponseEntity<>(veiculosmarca, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}	
	@PreAuthorize("hasRole(1) or hasRole(2)")
	@DeleteMapping("/delete/{idMarca}")
	public ResponseEntity<String> delete(@PathVariable Long idMarca) {

		try {

			String mensagem = this.veiculosmarcaservice.delete(idMarca);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findByMarca")
	public ResponseEntity<VeiculosMarca> findByMarca(@RequestParam String marca) {
		try {

			VeiculosMarca veiculosmarca = this.veiculosmarcaservice.findByMarca(marca);
			return new ResponseEntity<>(veiculosmarca, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

}
