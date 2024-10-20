package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.application.utils.BusinessUtils;
import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

public class ApplyForCreditUseCaseImpl implements ApplyForCreditUseCase {

    private final RequestCreditRepositoryPort repositoryPort;
    private final BusinessUtils businessUtils;

    public ApplyForCreditUseCaseImpl(
            RequestCreditRepositoryPort repositoryPort,
            BusinessUtils businessUtils) {
        this.repositoryPort = repositoryPort;
        this.businessUtils = businessUtils;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        CreditDecision creditDecision;
        if (businessUtils.isEligible(request.getAmount())) {
            creditDecision = CreditDecision.APPROVED;
        } else {
            creditDecision = CreditDecision.REJECTED;
        }
        return repositoryPort.save(request, creditDecision);
    }

}
