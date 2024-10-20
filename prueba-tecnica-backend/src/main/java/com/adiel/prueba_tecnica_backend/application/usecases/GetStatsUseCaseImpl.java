package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.GetStatsUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

import java.util.List;
import java.util.Map;

public class GetStatsUseCaseImpl implements GetStatsUseCase {
    private final RequestCreditRepositoryPort repositoryPort;

    public GetStatsUseCaseImpl(RequestCreditRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }


    @Override
    public Map<String, Long> getStats() {
        List<CreditResponse> list = repositoryPort.findAll();
        long approvedCount = list.stream().filter(element -> element.getDecision().equals(CreditDecision.APPROVED)).count();
        long rejectedCount = list.stream().filter(element -> element.getDecision().equals(CreditDecision.REJECTED)).count();
        return Map.of(
                CreditDecision.APPROVED.name().toLowerCase(), approvedCount,
                CreditDecision.REJECTED.name().toLowerCase(), rejectedCount
        );
    }
}
