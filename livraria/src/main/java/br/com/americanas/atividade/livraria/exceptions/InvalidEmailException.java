package br.com.americanas.atividade.livraria.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Email usado invalido")
public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException() {
        super("Email usado invalido");
    }
}
