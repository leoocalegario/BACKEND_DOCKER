	package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class AnuncioVeiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnuncio;

	@NotBlank
	private String cor;
	
	@NotBlank
	private String imagem;

	@NotBlank
	private String modelo;

	@NotNull
	private int ano;

	@NotNull
	private String combustivel;

	@NotNull
	private double valorcarro;

	//@Pattern(regexp = "^'", message = "Placa inválida")
	@NotBlank
	private String placacarro;

	@NotNull
	private int km;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("anuncioveiculo")
	private Vendedores vendedores;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("anuncioveiculo")
	private VeiculosMarca veiculosmarca;

	@OneToMany(mappedBy = "anuncioveiculo")
	@JsonIgnoreProperties("anuncioveiculo")
	private List<Proposta> proposta;
	
	@ManyToMany
	@JoinTable(name="carro_acessorio")
	private List<Acessorio> acessorios;
	
	// Getters and Setters

    public Long getIdAnuncio() {
        return idAnuncio;
    }

    public void setIdAnuncio(Long idAnuncio) {
        this.idAnuncio = idAnuncio;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getValorcarro() {
        return valorcarro;
    }

    public void setValorcarro(double valorcarro) {
        this.valorcarro = valorcarro;
    }

    public String getPlacacarro() {
        return placacarro;
    }

    public void setPlacacarro(String placacarro) {
        this.placacarro = placacarro;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public Vendedores getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedores vendedores) {
        this.vendedores = vendedores;
    }

    public VeiculosMarca getVeiculosmarca() {
        return veiculosmarca;
    }

    public void setVeiculosmarca(VeiculosMarca veiculosmarca) {
        this.veiculosmarca = veiculosmarca;
    }

    public List<Proposta> getProposta() {
        return proposta;
    }

    public void setProposta(List<Proposta> proposta) {
        this.proposta = proposta;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

}
