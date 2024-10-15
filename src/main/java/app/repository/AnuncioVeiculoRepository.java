package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import app.entity.AnuncioVeiculo;

public interface AnuncioVeiculoRepository extends JpaRepository<AnuncioVeiculo, Long> {

	public AnuncioVeiculo findByidAnuncio(Long idAnuncio);

	@Query("SELECT v FROM AnuncioVeiculo v WHERE v.modelo LIKE CONCAT('%', :mod, '%')")
	public List<AnuncioVeiculo> findByModeloLike(@Param("mod") String mod);

}	
