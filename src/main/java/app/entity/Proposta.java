package app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Proposta {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long idProposta;
	
	@NotNull
	private double valorProposta;

	@NotBlank
	private String nomeCliente;
	@NotBlank
	private String telefoneCliente;
	@NotBlank
	private String emailCliente;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnoreProperties("proposta")
	private AnuncioVeiculo anuncioveiculo;
	
	//@ManyToOne(cascade = CascadeType.PERSIST)
	//@JsonIgnoreProperties("proposta")
	//private Cliente cliente;
	
	// Getters and Setters

    public long getIdProposta() {
        return idProposta;
    }

    public void setIdProposta(long idProposta) {
        this.idProposta = idProposta;
    }

    public double getValorProposta() {
        return valorProposta;
    }

    public void setValorProposta(double valorProposta) {
        this.valorProposta = valorProposta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public AnuncioVeiculo getAnuncioveiculo() {
        return anuncioveiculo;
    }

    public void setAnuncioveiculo(AnuncioVeiculo anuncioveiculo) {
        this.anuncioveiculo = anuncioveiculo;
    }

}
