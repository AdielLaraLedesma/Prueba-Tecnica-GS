package com.adiel.prueba_tecnica_backend.domain.ports.in;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

public interface ApplyForCreditUseCase {

    CreditResponse applyCredit(CreditRequest request);

}
