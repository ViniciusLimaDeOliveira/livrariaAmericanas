package br.com.americanas.atividade.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;
import br.com.americanas.atividade.livraria.repository.LivroRepository;
import br.com.americanas.atividade.livraria.repository.PessoaRepository;
import br.com.americanas.atividade.livraria.repository.TransacaoRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
abstract class BaseTransacaoTest {

    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected TransacaoRepository repository;
        
    @Autowired
    protected LivroRepository livroRepository;

    @Autowired
    protected PessoaRepository pessoaRepository;

    protected Transacao criarTransacao(Long id,Pessoa pessoa,ArrayList<Livro> listaLivros) {
        Transacao transacao = new Transacao(id, pessoa, listaLivros);
        assertEquals(pessoa, transacao.getPessoa());   
        return transacao;
    }
    protected void deletarTransacao(Transacao transacao){
       repository.delete(transacao);
    }

    protected Transacao obtemTransacaoDoBanco(Transacao transacao) {
        return repository.findById(transacao.getId())
                .orElseThrow(NullPointerException::new);
    }
    protected void deletarPessoa(Pessoa pessoa){
        pessoaRepository.delete(pessoa);
     }
}