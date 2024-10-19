package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.infrastructure.entities.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaBranchRepository extends JpaRepository<BranchEntity, Long> {
}
