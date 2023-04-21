package br.com.americanas.atividade.livraria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.Console;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Pessoa;

@SpringBootTest
class PessoaControllerTest extends BasePessoaTest{
    private final String baseUri = "/pessoas";
    
    @Test
    void testPessoaExiste() throws Exception{
    Pessoa pessoaBase = criarPessoa( 101L, "pessoaTeste",
     "1111-1111-111-11", "teste@gmail.com",
 "(99)9-9999-9999", 100D, null);

    Long idPessoa = (long) (pessoaBase.getId());
    String response = mvc.perform(post(baseUri+"/"+idPessoa)
    .param("nome","pessoaTeste","cpf","1111-1111-111-11","email","teste@gmail.com",
                                        "telefone","(99)9-9999-8888","saldo","100D","transacaos","[]")
                                        .contentType(MediaType.APPLICATION_JSON))
                                        .andDo(print())
                                        .andExpect(status().isOk())
                                        .andReturn().getResponse().getContentAsString();

    assertEquals(response,pessoaBase,"ok");
    }
 
 
    @Test
    void testPessoaMudou() throws Exception{
     Pessoa base = criarPessoa( 101L, "pessoaTeste",
     "1111-1111-111-11", "teste@gmail.com",
 "(99)9-9999-9999", 100D, null);
     Pessoa pessoaTest = repository.save(base);
 
     pessoaTest.setNome("PessoaTesteNewName") ;
     pessoaTest.setCpf("1111-1111-111-12");	 
     pessoaTest.setEmail("testeMesmo@gmail.com")	; 
     pessoaTest.setTelefone("(99)9-9999-8888") ;
     pessoaTest.setSaldo(200D) ;
     assertNotEquals(pessoaTest,base,"ok");
    }
  
}
