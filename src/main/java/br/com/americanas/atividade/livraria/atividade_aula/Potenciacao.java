package br.com.americanas.atividade.livraria.atividade_aula;
/*
 * Criar uma função que receba dois números inteiros e realize a operação do primeiro elevado ao segundo.
*/
public class Potenciacao {
    
    double executar(int number1,int number2){
        if(number2<0) return elevarMenorQueZero(number1,number2);
        else return elevar(number1,number2);
    }
    
    private double elevarMenorQueZero(int number1, int number2) {
        if(number1<0) return  (double) -1/elevar(number1, number2*-1);
        else return  (double) 1/elevar(number1, number2*-1);
    }

    public double elevar(int number1,int number2){
        if(number2==0){
            return 1;
        }
        else return elevar(number1, number2-1)*number1;  
    }

}
