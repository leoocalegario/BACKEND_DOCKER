package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Proposta;

public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	public List<Proposta> findByvalorProposta(double valorProposta);

}
