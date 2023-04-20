package br.com.americanas.atividade.livraria.repository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.americanas.atividade.livraria.model.Pessoa;

@SpringBootTest
public class LivroRepositoryTest {
    @Autowired
    protected MockMvc mvc;

    @Autowired
    protected PessoaRepository repository;

    private final String baseUri = "/pessoa";
    @Test
   void testPessoaExiste() throws Exception{
    Pessoa pessoaTest = repository.save(new Pessoa( 101L, "pessoaTeste",
                                        "1111-1111-111-11", "teste@gmail.com",
                                    "(99)9-9999-9999", 100D, null));
    Long idPessoaFake = (long) (pessoaTest.getId());
    String response = mvc.perform(post(baseUri+"/"+idContaFake)
    .param("valor", "10")
    .contentType(MediaType.APPLICATION_JSON))
    .andDo(print())
    .andExpect(status().isNotFound())
    .andReturn().getResponse().getErrorMessage();

    assertEquals("Recurso não encontrado.",response);
   }
}
