package br.com.americanas.atividade.livraria.atividade_aula;
/**
 * Criar uma classe que obtém dois números inteiros e devolve o resultado da divisão dos mesmos.
 * Essa classe sempre divide o maior número pelo menor número.
 * No caso de uma divisão por 0 devemos devolver `null`
 */

public class Divisao {
    

    Double executar(int number1,int number2){
        if(number1==number2 && number1!=0){
            return 1.0;
        }else if(number1>number2){
            if(number2==0){
                return null;
            } else return (double) number1/number2;
        } else if(number1==0){
            return null;
        } return (double) number2/number1;
    }
}
