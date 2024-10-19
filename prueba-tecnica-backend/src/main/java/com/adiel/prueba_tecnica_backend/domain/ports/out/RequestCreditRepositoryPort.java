package com.adiel.prueba_tecnica_backend.domain.ports.out;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

public interface RequestCreditRepositoryPort {

    CreditResponse save(CreditRequest request);

}
