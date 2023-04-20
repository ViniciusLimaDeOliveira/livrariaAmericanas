package br.com.americanas.atividade.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.com.americanas.atividade.livraria.model.Livro;

@CrossOrigin
//@RepositoryRestResource
public interface LivroRepository  extends JpaRepository<Livro,Long>{
    
}
