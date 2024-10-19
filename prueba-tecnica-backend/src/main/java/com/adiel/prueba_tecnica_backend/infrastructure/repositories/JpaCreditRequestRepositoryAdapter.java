package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.CreditRequestEntity;
import org.springframework.stereotype.Component;

@Component
public class JpaCreditRequestRepositoryAdapter implements RequestCreditRepositoryPort {

    private final JpaCreditRequestRepository repository;

    public JpaCreditRequestRepositoryAdapter(JpaCreditRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreditResponse save(CreditRequest request) {
        CreditRequestEntity entity = CreditRequestEntity.fromDomainModel(request);
        CreditRequestEntity savedEntity = repository.save(entity);
        return savedEntity.toDomainModel();
    }
}
