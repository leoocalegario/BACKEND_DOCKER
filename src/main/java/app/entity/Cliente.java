package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;

	@NotBlank
	private String senha;

	@Email(message = "Email invalido")
	@NotBlank
	private String email;

	@NotBlank
	private String nome;

	@NotBlank
	private String telefone;
	
	
	//VALIDACAO DE IDADE
	@Min(value = 18, message = "A pessoa deve ter pelo menos 18 anos de idade")
	@Max(value = 120, message = "A pessoa não pode ter mais de 120 anos de idade")
	@NotNull
	private int idade;

	@NotBlank
	private String endereco;

	@NotBlank
	private String cidade;

	@NotBlank
	private String estado;

	@NotBlank
	private String DataCriado;
	
	//SINALIZA SE É CLIENTE OU ADM
	@Column(name = "flag_user")
	@Basic
	private boolean flagTipoUser;

	//IDENTIFICA SE O USUARIO ESTA ATIVO ADM/CLIENTE PADRAO
	@Column(name = "flag_ativo")
	@Basic
	private boolean flagAtivo;

	//@OneToMany(mappedBy = "cliente")
	//@JsonIgnoreProperties("cliente")
	//private List<Proposta> proposta;
	
	// Getters and Setters

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDataCriado() {
        return DataCriado;
    }

    public void setDataCriado(String DataCriado) {
        this.DataCriado = DataCriado;
    }

    public boolean isFlagTipoUser() {
        return flagTipoUser;
    }

    public void setFlagTipoUser(boolean flagTipoUser) {
        this.flagTipoUser = flagTipoUser;
    }

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

}
