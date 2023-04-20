package br.com.americanas.atividade.livraria.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;
import br.com.americanas.atividade.livraria.repository.PessoaRepository;
import br.com.americanas.atividade.livraria.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
//WIP
@Service
@Slf4j
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final PessoaRepository pessoaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository,PessoaRepository pessoaRepository){
        this.transacaoRepository  = transacaoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Transacao venda(Transacao transacao) {
        List<Livro> carrinho = transacao.getLivros();
        Pessoa cliente = pessoaRepository.findById(transacao.getPessoa().getId()).get();
        Double somaTotal=0.0;
        Double valorEmConta = cliente.getSaldo();
        for (Livro livro : carrinho) {
            somaTotal+=livro.getPreco();
        }
        if(valorEmConta>=somaTotal){
            cliente.setSaldo((valorEmConta-somaTotal)); 
            pessoaRepository.save(cliente);   
            return transacaoRepository.save(transacao);
        }else{
            return null;
        }

    }
}
