package br.com.americanas.atividade.livraria.atividade_aula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class potencialTeste {
    private Potenciacao potencia = new Potenciacao();
    //- Potenciação simples, exemplo: 5^3 = 125
    @Test
    void test1() {
        double resultado = potencia.executar(5, 3);
        assertEquals(125, resultado);
    }
//- Qualquer número elevado a 0 é igual a 1.
    // Positivo, negativo, 0
      @Test
    void test2() {
        double resultado = potencia.executar(2, 2);
        assertEquals(4, resultado);
    }
    @Test
    void test3() {
        double resultado = potencia.executar(2, 0);
        assertEquals(1, resultado);
    }
    @Test
    void test4() {
        double resultado = potencia.executar(2, -2);
        assertEquals(0.25, resultado);
    }
    @Test
    void test5() {
        double resultado = potencia.executar(-2, -2);
        assertEquals(-0.25, resultado);
    }
     @Test
    void test6() {
        double resultado = potencia.executar(-2, 2);
        assertEquals(4, resultado);
    }
        @Test
    void test7() {
        double resultado = potencia.executar(-2, 3);
        assertEquals(-8, resultado);
    }

//- Qualquer número elevado a 1 é ele mesmo.
   // Positivo, negativo, 0
   @Test
    void test8() {
        double resultado = potencia.executar(-2, 3);
        assertEquals(-8, resultado);
    }
      @Test
    void test9() {
        double resultado = potencia.executar(2, 1);
        assertEquals(2, resultado);
    }
          @Test
    void test10() {
        double resultado = potencia.executar(0, 1);
        assertEquals(0, resultado);
    }
    @Test
    void test10_1() {
        double resultado = potencia.executar(0, 100);
        assertEquals(0, resultado);
    }
    @Test
    void test11() {
        double resultado = potencia.executar(-2, 1);
        assertEquals(-2, resultado);
    }
    @Test
    void test12() {
        double resultado = potencia.executar(-2, 1);
        assertEquals(-2, resultado);
    }
    @Test
    void test13() {
        double resultado = potencia.executar(0, -1);
        assertEquals(Double.POSITIVE_INFINITY,resultado);
    }
    
}
