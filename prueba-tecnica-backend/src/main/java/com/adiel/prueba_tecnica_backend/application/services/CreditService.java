package com.adiel.prueba_tecnica_backend.application.services;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUserCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditService implements ApplyForCreditUseCase, ApplyForCreditsUserCase {

    private final ApplyForCreditUseCase applyForCreditUseCase;
    private final ApplyForCreditsUserCase applyForCreditsUserCase;

    public CreditService(
            ApplyForCreditUseCase applyForCreditUseCase,
            ApplyForCreditsUserCase applyForCreditsUserCase) {
        this.applyForCreditUseCase = applyForCreditUseCase;
        this.applyForCreditsUserCase = applyForCreditsUserCase;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        return applyForCreditUseCase.applyCredit(request);
    }

    @Override
    public List<CreditResponse> applyCredit(int total) {
        return applyForCreditsUserCase.applyCredit(total);
    }
}
