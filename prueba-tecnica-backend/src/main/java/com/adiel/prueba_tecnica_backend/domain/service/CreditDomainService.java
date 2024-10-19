package com.adiel.prueba_tecnica_backend.domain.service;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;

public class CreditDomainService {

    public void evaluateCredit(CreditRequest creditRequest) {
        if (creditRequest.isEligible()) {
            creditRequest.setDecision(CreditDecision.APPROVED);
        } else {
            creditRequest.setDecision(CreditDecision.REJECTED);
        }
    }

}
