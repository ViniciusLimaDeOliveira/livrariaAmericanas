package br.com.americanas.atividade.livraria.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.americanas.atividade.livraria.exceptions.ResourceNotFoundException;
import br.com.americanas.atividade.livraria.exceptions.ValorInvalidoException;
import br.com.americanas.atividade.livraria.model.Transacao;
import br.com.americanas.atividade.livraria.repository.TransacaoRepository;
import br.com.americanas.atividade.livraria.service.TransacaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transacao")
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoRepository repository;
    private final TransacaoService service;
    @GetMapping("{id}")
    public Transacao getTransacao(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping
    public List<Transacao> getTransacao() {
        return repository.findAll();
    }

    @PostMapping
    public Transacao createTransacao(@RequestBody Transacao transacao) {
        Transacao resposta  = service.venda(transacao);
        if(resposta!=null){
            return resposta;
        } else {
            throw new ValorInvalidoException();
        }
    }
    
}
