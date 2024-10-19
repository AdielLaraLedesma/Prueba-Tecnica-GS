package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.Client;
import com.adiel.prueba_tecnica_backend.domain.ports.out.ClientRepositoryPort;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.ClientEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaClientRepositoryAdapter implements ClientRepositoryPort {

    private final JpaClientRepository repository;

    public JpaClientRepositoryAdapter(JpaClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll().stream().map(ClientEntity::toDomainModel).toList();
    }
}
