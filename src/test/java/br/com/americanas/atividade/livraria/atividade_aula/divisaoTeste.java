package br.com.americanas.atividade.livraria.atividade_aula;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class divisaoTeste {
    private Divisao divisao = new Divisao();

    @Test
    void test1() {
        double resultado = divisao.executar(6, 2);
        assertEquals(3, resultado);
    }

    @Test
    void test2() {
        double resultado = divisao.executar(7, 2);
        assertEquals(3.5, resultado);
    }

    @Test
    void test3() {
        double resultado = divisao.executar(9, 2);
        assertEquals(4.5, resultado);

        resultado = divisao.executar(2, 9);
        assertEquals(4.5, resultado);
    }
    @Test
    void test4() {
        Double resultado = divisao.executar(0, 2);
        assertNull(resultado);
    }

    @Test
    void test5() {
        Double resultado = divisao.executar(2, 0);
        assertNull(resultado);
    }
    @Test
        void testFinal() {
            double result = divisao.executar(0, -10);
            assertTrue(result==0);
        }
}
