package br.com.americanas.atividade.livraria.service;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
    
    
    private static final String EMAIL_REGEX =
     "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    public boolean validate(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
