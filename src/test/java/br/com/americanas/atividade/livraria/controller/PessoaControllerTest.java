package br.com.americanas.atividade.livraria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Console;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.americanas.atividade.livraria.model.Pessoa;
import br.com.americanas.atividade.livraria.model.Transacao;


@SpringBootTest
class PessoaControllerTest extends BasePessoaTest{
    private final String baseUri = "/pessoas";
    
    @Test
    void testPessoaExiste() throws Exception{
    Pessoa pessoaBase = criarPessoa(101L,"pessoaTeste",
     "1111-1111-111-11", "teste@gmail.com",
 "(99)9-9999-9999", 100D);

    String response = mvc.perform(MockMvcRequestBuilders.
    post(baseUri)
    .content(new ObjectMapper().writeValueAsString(pessoaBase))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andReturn().getResponse().getContentAsString();  

    ObjectMapper mapper = new ObjectMapper();  
    String json = mapper.writeValueAsString( pessoaBase );                            
    assertEquals(json,response, "OK");
    deletarPessoa(pessoaBase);
    }
    @Test
    void testPessoaNaoExiste() throws Exception{
    Pessoa pessoaBase = criarPessoa(101L,"pessoaTeste",
     "1111-1111-111-11", "teste@gmail.com",
 "(99)9-9999-9999", 100D);
    Long idPessoaFake = pessoaBase.getId()+1;
    String response = mvc.perform(MockMvcRequestBuilders.
    get(baseUri+"/"+idPessoaFake)
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isNotFound())
    .andReturn().getResponse().getContentAsString();  
                         
    assertEquals(response,"");
    deletarPessoa(pessoaBase);
    }

    @Test
    void testPessoaMudou() throws Exception{
     Pessoa pessoaBase = criarPessoa(101L,"pessoaTeste",
     "1111-1111-111-11", "teste@gmail.com",
 "(99)9-9999-9999", 100D);
     Pessoa pessoaTest = repository.save(pessoaBase);

     assertEquals(pessoaTest,pessoaBase,"ok");

     pessoaTest.setNome("PessoaTesteNewName") ;
     pessoaTest.setCpf("1111-1111-111-12");	 
     pessoaTest.setEmail("testeMesmo@gmail.com")	; 
     pessoaTest.setTelefone("(99)9-9999-8888") ;
     pessoaTest.setSaldo(200D) ;
     assertNotEquals(pessoaTest,pessoaBase,"ok");
    
     deletarPessoa(pessoaBase);
    }
  
}
