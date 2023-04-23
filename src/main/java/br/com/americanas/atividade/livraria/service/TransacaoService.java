package br.com.americanas.atividade.livraria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;
import br.com.americanas.atividade.livraria.repository.LivroRepository;
import br.com.americanas.atividade.livraria.repository.PessoaRepository;
import br.com.americanas.atividade.livraria.repository.TransacaoRepository;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final PessoaRepository pessoaRepository;
    private final LivroRepository livroRepository;
    
    public TransacaoService(TransacaoRepository transacaoRepository,PessoaRepository pessoaRepository,LivroRepository livroRepository){
        this.transacaoRepository  = transacaoRepository;
        this.pessoaRepository = pessoaRepository;
        this.livroRepository = livroRepository;
    }

    public Transacao venda(Transacao transacao){
        List<Livro> carrinho = transacao.getLivros();
        Optional<Pessoa> optional = pessoaRepository.findById(transacao.getPessoa().getId());
        Double somaTotal=0.0;
        if (optional.isEmpty()) {
            return null;
          }
        else{ 
        Pessoa cliente = optional.get();
        Double valorEmConta = cliente.getSaldo();
        for (Livro livro : carrinho) {
            if(livro.getQuantidade()>0)
                somaTotal+=livro.getPreco();
            else somaTotal+=0;
        }
        if(valorEmConta>=somaTotal){
            cliente.setSaldo((valorEmConta-somaTotal));
            for (Livro livro : carrinho) {
                if(livro.getQuantidade()>0){
                    livro.setQuantidade(livro.getQuantidade()-1);
                    livroRepository.save(livro);    
                }
            } 
            pessoaRepository.save(cliente);   
            return transacaoRepository.save(transacao);
        }else{
            return null;
        }
    }

    }
}
