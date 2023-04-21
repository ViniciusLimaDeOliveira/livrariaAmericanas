package br.com.americanas.atividade.livraria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.repository.LivroRepository;

public class BaselivroTest {
    
    @Autowired
    protected MockMvc mvc;
    
    @Autowired
    protected LivroRepository repository;

    protected Livro criarConta(Long id,String nome,String edicao,String autor,Double preco,Long quantidade) {
        Livro livroBase = repository.save(new Livro(id, nome, edicao, autor, preco, quantidade));
        livroBase = repository.save(livroBase);
        Livro livroTeste = repository.getReferenceById(id);
        assertEquals(livroBase,livroTeste,"OK");
        return livroBase;
    }

    protected Livro obtemLivro(Livro livroBase) {
        return repository.findById(livroBase.getId())
                .orElseThrow(NullPointerException::new);
    }

}
