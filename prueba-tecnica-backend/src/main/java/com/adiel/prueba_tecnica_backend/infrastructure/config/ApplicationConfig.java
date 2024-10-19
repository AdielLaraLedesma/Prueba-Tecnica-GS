package com.adiel.prueba_tecnica_backend.infrastructure.config;

import com.adiel.prueba_tecnica_backend.application.services.CreditService;
import com.adiel.prueba_tecnica_backend.application.usecases.ApplyForCreditUseCaseImpl;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import com.adiel.prueba_tecnica_backend.infrastructure.repositories.JpaCreditRequestRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreditService creditService(RequestCreditRepositoryPort port){
        return new CreditService(new ApplyForCreditUseCaseImpl(port));
    }

    /*@Bean
    public RequestCreditRepositoryPort repositoryPort(JpaCreditRequestRepositoryAdapter adapter){
        return adapter;
    }*/


}
