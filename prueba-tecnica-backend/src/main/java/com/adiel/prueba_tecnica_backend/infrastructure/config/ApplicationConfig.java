package com.adiel.prueba_tecnica_backend.infrastructure.config;

import com.adiel.prueba_tecnica_backend.application.services.CreditService;
import com.adiel.prueba_tecnica_backend.application.usecases.ApplyForCreditUseCaseImpl;
import com.adiel.prueba_tecnica_backend.application.usecases.ApplyForCreditsUseCaseImpl;
import com.adiel.prueba_tecnica_backend.domain.ports.out.BranchRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.ClientRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CreditService creditService(
            RequestCreditRepositoryPort requestCreditRepositoryPort,
            ClientRepositoryPort clientRepositoryPort,
            BranchRepositoryPort branchRepositoryPort
            ){
        return new CreditService(
                new ApplyForCreditUseCaseImpl(requestCreditRepositoryPort),
                new ApplyForCreditsUseCaseImpl(
                        requestCreditRepositoryPort,
                        clientRepositoryPort,
                        branchRepositoryPort
                )
        );
    }

}
