package br.com.americanas.atividade.livraria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.metamodel.Type;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        EntityManager em = entityManagerFactory.createEntityManager();
        config.exposeIdsFor(em.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
    }
}
