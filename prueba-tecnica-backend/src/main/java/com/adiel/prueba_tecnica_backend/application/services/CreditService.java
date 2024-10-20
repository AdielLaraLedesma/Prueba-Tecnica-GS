package com.adiel.prueba_tecnica_backend.application.services;

import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.GetStatsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CreditService implements ApplyForCreditUseCase, ApplyForCreditsUseCase, GetStatsUseCase {

    private final ApplyForCreditUseCase applyForCreditUseCase;
    private final ApplyForCreditsUseCase applyForCreditsUseCase;
    private final GetStatsUseCase getStatsUseCase;

    public CreditService(
            ApplyForCreditUseCase applyForCreditUseCase,
            ApplyForCreditsUseCase applyForCreditsUseCase,
            GetStatsUseCase getStatsUseCase) {
        this.applyForCreditUseCase = applyForCreditUseCase;
        this.applyForCreditsUseCase = applyForCreditsUseCase;
        this.getStatsUseCase = getStatsUseCase;
    }

    @Override
    public CreditResponse applyCredit(CreditRequest request) {
        return applyForCreditUseCase.applyCredit(request);
    }

    @Override
    public Map<String, Long> getStats() {
        return getStatsUseCase.getStats();
    }

    @Override
    public List<CreditResponse> applyCredit(int total) {
        return applyForCreditsUseCase.applyCredit(total);
    }
}
