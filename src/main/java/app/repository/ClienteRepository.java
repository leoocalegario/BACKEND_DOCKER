package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public List<Cliente> findByNome(String nome);

	@Query("FROM Cliente c where c.nome LIKE %:nome")
	public List<Cliente> findByNomeLike(String nome);

	public List<Cliente> findByCidade(String cidade);
}
