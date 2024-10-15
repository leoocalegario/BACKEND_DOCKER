package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VeiculosMarca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMarca;

	@NotBlank
	private String marca;

	@OneToMany(mappedBy = "veiculosmarca")
	@JsonIgnoreProperties("veiculosmarca")
	private List<AnuncioVeiculo> anuncioveiculo;
	
	 // Getters and Setters

    public Long getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<AnuncioVeiculo> getAnuncioveiculo() {
        return anuncioveiculo;
    }

    public void setAnuncioveiculo(List<AnuncioVeiculo> anuncioveiculo) {
        this.anuncioveiculo = anuncioveiculo;
    }
	
}
