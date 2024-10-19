package com.adiel.prueba_tecnica_backend.domain.ports.out;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;

import java.util.List;

public interface BranchRepositoryPort {

    List<Branch> findAll();

}
