package app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Acessorio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message="Não pode ser Nulo")
	private String nome;
	
	// Getter para o campo 'id'
    public long getId() {
        return id;
    }

    // Setter para o campo 'id'
    public void setId(long id) {
        this.id = id;
    }

    // Getter para o campo 'nome'
    public String getNome() {
        return nome;
    }

    // Setter para o campo 'nome'
    public void setNome(String nome) {
        this.nome = nome;
    }
	
	
}
