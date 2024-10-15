package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.VeiculosMarca;

public interface VeiculosMarcaRepository extends JpaRepository<VeiculosMarca, Long> {

	public VeiculosMarca findByIdMarca(Long idMarca);

	public VeiculosMarca findByMarca(String marca);
}
