package br.com.americanas.atividade.livraria.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Recurso não encontrado.")
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("Recurso não encontrado.");
    }
}
