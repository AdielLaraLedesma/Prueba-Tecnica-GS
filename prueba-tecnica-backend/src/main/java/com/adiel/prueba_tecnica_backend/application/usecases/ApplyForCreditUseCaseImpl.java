package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

public class ApplyForCreditUseCaseImpl implements ApplyForCreditUseCase {

    private final RequestCreditRepositoryPort repositoryPort;

    public ApplyForCreditUseCaseImpl(RequestCreditRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        if (request.isEligible()) {
            request.setDecision(CreditDecision.APPROVED);
        } else {
            request.setDecision(CreditDecision.REJECTED);
        }
        return repositoryPort.save(request);
    }
}
