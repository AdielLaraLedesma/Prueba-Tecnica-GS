package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.CreditRequestEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaCreditRequestRepositoryAdapter implements RequestCreditRepositoryPort {

    private final JpaCreditRequestRepository repository;

    public JpaCreditRequestRepositoryAdapter(JpaCreditRequestRepository repository) {
        this.repository = repository;
    }

    @Override
    public CreditResponse save(CreditRequest request, CreditDecision decision) {
        CreditRequestEntity entity = CreditRequestEntity.fromDomainModel(request, decision);
        CreditRequestEntity savedEntity = repository.save(entity);
        return savedEntity.toDomainModel();
    }

    @Override
    public List<CreditResponse> findAll() {
        return repository.findAll().stream().map(CreditRequestEntity::toDomainModel).toList();
    }
}
