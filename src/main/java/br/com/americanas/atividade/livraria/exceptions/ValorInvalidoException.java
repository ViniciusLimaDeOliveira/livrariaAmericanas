package br.com.americanas.atividade.livraria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE, reason = "Fundos insuficientes.")
public class ValorInvalidoException extends RuntimeException {

    public ValorInvalidoException() {
        super("Fundos insuficientes");
    }
}
