package com.adiel.prueba_tecnica_backend.application.services;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreditService implements ApplyForCreditUseCase {

    private final ApplyForCreditUseCase applyForCreditUseCase;

    public CreditService(ApplyForCreditUseCase applyForCreditUseCase) {
        this.applyForCreditUseCase = applyForCreditUseCase;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        return applyForCreditUseCase.applyCredit(request);
    }
}
