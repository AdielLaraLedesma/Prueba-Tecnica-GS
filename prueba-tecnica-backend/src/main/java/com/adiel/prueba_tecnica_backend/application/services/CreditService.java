package com.adiel.prueba_tecnica_backend.application.services;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService implements ApplyForCreditUseCase, ApplyForCreditsUseCase {

    private final ApplyForCreditUseCase applyForCreditUseCase;
    private final ApplyForCreditsUseCase applyForCreditsUseCase;

    public CreditService(
            ApplyForCreditUseCase applyForCreditUseCase,
            ApplyForCreditsUseCase applyForCreditsUseCase) {
        this.applyForCreditUseCase = applyForCreditUseCase;
        this.applyForCreditsUseCase = applyForCreditsUseCase;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        return applyForCreditUseCase.applyCredit(request);
    }

    @Override
    public List<CreditResponse> applyCredit(int total) {
        return applyForCreditsUseCase.applyCredit(total);
    }
}
