package app.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Vendedores implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVendedor;

	@NotBlank
	private String Senha;

	@Email
	private String email;

	@NotBlank
	private String nome;

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

	@Column(name = "flag_User") //flag para distincao de vendedor e admin
	private int flagTipoUser;

	@Column(name = "flag_ativo") //flag para distincao de usuario ativo e desativado
	@Basic
	private boolean flagAtivo;

	@OneToMany(mappedBy = "vendedores") //relacao de cardialidade one to many
	@JsonIgnoreProperties("vendedores")
	private List<AnuncioVeiculo> anuncioveiculo;
	
	
	
	
	// Getters and Setters

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
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

    public int getFlagTipoUser() {
        return flagTipoUser;
    }

    public void setFlagTipoUser(int flagTipoUser) {
        this.flagTipoUser = flagTipoUser;
    }

    public boolean isFlagAtivo() {
        return flagAtivo;
    }

    public void setFlagAtivo(boolean flagAtivo) {
        this.flagAtivo = flagAtivo;
    }

    public List<AnuncioVeiculo> getAnuncioveiculo() {
        return anuncioveiculo;
    }

    public void setAnuncioveiculo(List<AnuncioVeiculo> anuncioveiculo) {
        this.anuncioveiculo = anuncioveiculo;
    }

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
	    authorities.add(new SimpleGrantedAuthority( String.format("%d", this.flagTipoUser) ));
	    return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.Senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
