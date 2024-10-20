package com.adiel.prueba_tecnica_backend.domain.ports.out;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

import java.util.List;

public interface RequestCreditRepositoryPort {

    CreditResponse save(CreditRequest request, CreditDecision decision);

    List<CreditResponse> findAll();

}
