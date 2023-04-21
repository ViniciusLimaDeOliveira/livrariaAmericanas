package br.com.americanas.atividade.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;
import br.com.americanas.atividade.livraria.repository.PessoaRepository;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
abstract class BasePessoaTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected PessoaRepository repository;

    protected Pessoa criarPessoa(Long id,String name,String cpf,String email,String telefone,Double saldo,List<Transacao> transacoes) {
        Pessoa pessoaBase = repository.save(new Pessoa( id, name,cpf, email,telefone, saldo, transacoes));
        pessoaBase = repository.save(pessoaBase);
        assertEquals(saldo, pessoaBase.getSaldo());
        return pessoaBase;
    }

    protected Pessoa obtemContaDoBanco(Pessoa pessoaBase) {
        return repository.findById(pessoaBase.getId())
                .orElseThrow(NullPointerException::new);
    }

}
