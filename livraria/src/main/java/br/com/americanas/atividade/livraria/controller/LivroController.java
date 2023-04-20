package br.com.americanas.atividade.livraria.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.americanas.atividade.livraria.exceptions.ResourceNotFoundException;
import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.repository.LivroRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    
    private LivroRepository repository;
    @GetMapping("{id}")
    public Livro getLivro(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping
    public List<Livro> getLivro() {
        return repository.findAll();
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @PutMapping
    public Livro atualizaLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }
}
