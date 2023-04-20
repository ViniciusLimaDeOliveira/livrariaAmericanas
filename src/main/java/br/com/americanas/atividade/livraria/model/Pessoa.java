package br.com.americanas.atividade.livraria.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pessoa implements Serializable{
    @Id
    @SequenceGenerator(name = "pessoaSequenceGenerator", sequenceName = "PESSOA_SQ", initialValue = 100)
    @GeneratedValue(generator = "pessoaSequenceGenerator", strategy = GenerationType.SEQUENCE)
    @Column(updatable = false)
    private Long id;

    private String name;

    private String cpf;
    
    private String email;
    
    private String telefone;

    private Double saldo;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Transacao> transacaos;
}
