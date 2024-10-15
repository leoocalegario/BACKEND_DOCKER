package app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Vendedores;

public interface VendedoresRepository extends JpaRepository<Vendedores, Long> {

	public Vendedores findByIdVendedor(Long idVendedor); // metodo de busca pelo id do vendedor

	@Query("FROM Vendedores v where v.nome LIKE %:nome") // metodo de busca JPQL
	public List<Vendedores> findByNomeLike(String nome);

	public Optional<Vendedores> findByEmail(String email); // metodo de busca pelo email do vendedor
}
