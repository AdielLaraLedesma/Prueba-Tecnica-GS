package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

import java.math.BigDecimal;

public class ApplyForCreditUseCaseImpl implements ApplyForCreditUseCase {

    private final RequestCreditRepositoryPort repositoryPort;

    public ApplyForCreditUseCaseImpl(RequestCreditRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        CreditDecision creditDecision;
        if (isEligible(request.getAmount())) {
            creditDecision = CreditDecision.APPROVED;
        } else {
            creditDecision = CreditDecision.REJECTED;
        }
        return repositoryPort.save(request, creditDecision);
    }

    public boolean isEligible(BigDecimal amount) {
        return amount.compareTo(BigDecimal.valueOf(5000)) <= 0;
    }
}
