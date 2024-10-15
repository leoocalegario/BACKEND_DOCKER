package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import app.controller.List;
import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNome() + "salvo com sucesso";
	}

	public String update(Long id, Cliente cliente) {
		cliente.setIdUser(id);
		this.clienteRepository.save(cliente);
		return cliente.getNome() + "alterado com sucesso";
	}

	public String delete(Long id) {
		this.clienteRepository.deleteById(id);
		return "Cliente Deletado com sucesso";
	}

	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();

	}

	public Cliente findById(Long id) {
		Cliente cliente = this.clienteRepository.findById(id).get();
		return cliente;
	}

	public List<Cliente> findbyNome(String nome) {
		List<Cliente> lista = clienteRepository.findByNomeLike(nome);
		return lista;
	}

	public List<Cliente> findByCidade(String cidade) {
		List<Cliente> lista = clienteRepository.findByCidade(cidade);
		return lista;

	}

	public List<Cliente> findByNomeLike(String nome) {
		List<Cliente> lista = clienteRepository.findByNomeLike(nome);
		return lista;
	}

}
