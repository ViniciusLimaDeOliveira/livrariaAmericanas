package br.com.americanas.atividade.livraria.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.americanas.atividade.livraria.model.Livro;

@SpringBootTest
class LivroControllerTest extends BaselivroTest{
    private final String baseUri = "/livros";




    @Test
    void testLivroExiste() throws Exception{
        Livro livroBase = criarLivro(101L, "testeNome", "1", "TesteAutor", 50.0, 3L);

    String response = mvc.perform(MockMvcRequestBuilders.
    post(baseUri)
    .content(new ObjectMapper().writeValueAsString(livroBase))
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isOk())
    .andReturn().getResponse().getContentAsString();  

    ObjectMapper mapper = new ObjectMapper();  
    String json = mapper.writeValueAsString( livroBase );                            
    assertEquals(json,response, "OK");
    deletarLivro(livroBase);
    }


    @Test
    void testLivroNaoExiste() throws Exception{
    Livro livroBase = criarLivro(101L, "testeNome", "1", "TesteAutor", 50.0, 3L);
    Long idFake = livroBase.getId()+1;
    String response = mvc.perform(MockMvcRequestBuilders.
    get(baseUri+"/"+idFake)
    .contentType(MediaType.APPLICATION_JSON)
    .accept(MediaType.APPLICATION_JSON))
    .andExpect(status().isNotFound())
    .andReturn().getResponse().getContentAsString();  
                         
    assertEquals(response,"");
    deletarLivro(livroBase);
    }

    @Test
    void testLivroMudou() throws Exception{
    Livro livroBase = criarLivro(101L, "testeNome", "1", "TesteAutor", 50.0, 3L);
    Livro livroTest = livroBase;
     assertEquals(livroTest,livroBase,"ok");
     livroTest.setNome("PessoaTesteNewName") ;
     livroTest.setEdicao("1111-1111-111-12");	 
     livroTest.setAutor("testeMesmo@gmail.com")	; 
     livroTest.setPreco(100.0) ;
     livroTest.setQuantidade(200L) ;
     
     assertEquals(livroBase, livroTest);
     deletarLivro(livroBase);
    }



   
}
