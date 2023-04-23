package br.com.americanas.atividade.livraria.controller;

import java.util.ArrayList;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.americanas.atividade.livraria.model.Livro;
import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
@SpringBootTest
class TransacaoControllerTest extends BaseTransacaoTest{
    private final String baseUri = "/transacaos";
    @Test
    void testPessoaExiste() throws Exception{
   
    Pessoa pessoa = new Pessoa(101L,"pessoaTeste",
    "1111-1111-111-11", "teste@gmail.com",
"(99)9-9999-9999", 100D);
Transacao transacaoBase = criarTransacao(103L,pessoa,new ArrayList<Livro>());

    // String response =  mvc.perform(post(baseUri)
    // .param("pessoa",new ObjectMapper().writeValueAsString(pessoa),"livros",new ArrayList<Livro>().toString())
    // .contentType(MediaType.APPLICATION_JSON))
    //                     .andDo(print())
    //                     .andExpect(status().isOk())
    //                     .andReturn().getResponse().getContentAsString();
    String response = mvc.perform(MockMvcRequestBuilders.
    post(baseUri)
    .content(new ObjectMapper().writeValueAsString(transacaoBase))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andReturn().getResponse().getContentAsString();  
    
    ObjectMapper mapper = new ObjectMapper();  
    String json = mapper.writeValueAsString( transacaoBase ); 

    assertEquals(response,transacaoBase, "OK");
    deletarTransacao(transacaoBase);
    deletarPessoa(pessoa);
    }
}
