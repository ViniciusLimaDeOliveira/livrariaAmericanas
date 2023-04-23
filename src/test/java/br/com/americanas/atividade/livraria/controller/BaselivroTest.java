package br.com.americanas.atividade.livraria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.repository.LivroRepository;

@SpringBootTest
@AutoConfigureMockMvc
abstract class BaselivroTest {
    
    @Autowired
    protected MockMvc mvc;
    
    @Autowired
    protected LivroRepository repository;

    protected Livro criarLivro(Long id,String nome,String edicao,String autor,Double preco,Long quantidade) {
        Livro livroBase = repository.save(new Livro(id, nome, edicao, autor, preco, quantidade));
        assertEquals(preco,livroBase.getPreco(),"OK");
        return livroBase;
    }

    protected Livro obtemLivro(Livro livroBase) {
        return repository.findById(livroBase.getId())
                .orElseThrow(NullPointerException::new);
    }
    protected void deletarLivro(Livro livroBase) {
        repository.delete(livroBase);
    }
}
