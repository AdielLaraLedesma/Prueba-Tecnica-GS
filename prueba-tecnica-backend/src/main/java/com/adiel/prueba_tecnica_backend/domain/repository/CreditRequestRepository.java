package com.adiel.prueba_tecnica_backend.domain.repository;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

public interface CreditRequestRepository {

    CreditResponse save(CreditRequest creditRequest);
}
