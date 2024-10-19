package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import com.adiel.prueba_tecnica_backend.domain.ports.out.BranchRepositoryPort;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.BranchEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JpaBranchRepositoryAdapter implements BranchRepositoryPort {

    private final JpaBranchRepository repository;

    public JpaBranchRepositoryAdapter(JpaBranchRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Branch> findAll() {
        return repository.findAll().stream().map(BranchEntity::toDomainModel).toList();
    }
}
