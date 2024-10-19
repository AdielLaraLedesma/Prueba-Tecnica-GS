package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.infrastructure.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
}