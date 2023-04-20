package br.com.americanas.atividade.livraria.model;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transacao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
        name = "transacao_livro",
        joinColumns = { @JoinColumn(name = "transacao_id") },
        inverseJoinColumns = { @JoinColumn(name = "livro_id") }
    )
    private List<Livro> livros;

    

}
