package br.com.americanas.atividade.livraria.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.americanas.atividade.livraria.exceptions.InvalidEmailException;
import br.com.americanas.atividade.livraria.exceptions.ResourceNotFoundException;
import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.repository.PessoaRepository;
import br.com.americanas.atividade.livraria.service.EmailValidator;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaRepository repository;
    private final EmailValidator emailValidator;

    @GetMapping("{id}")
    public Pessoa getPessoa(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping
    public List<Pessoa> getPessoas() {
        return repository.findAll();
    }

    @PostMapping
    public Pessoa createPessoa(@RequestBody Pessoa pessoa) {
        if(pessoa!=null){
            if(emailValidator.validate(pessoa.getEmail())){
                return repository.save(pessoa);
            } else {
                throw new InvalidEmailException();
            }
        } 
        return null; 
    }

    @PutMapping
    public Pessoa atualizaPessoa(@RequestBody Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
