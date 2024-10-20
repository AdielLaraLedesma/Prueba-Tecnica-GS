package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.application.utils.BusinessUtils;
import com.adiel.prueba_tecnica_backend.domain.models.*;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.BranchRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.ClientRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

public class ApplyForCreditsUseCaseImpl implements ApplyForCreditsUseCase {
    private final RequestCreditRepositoryPort repositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;
    private final BranchRepositoryPort branchRepositoryPort;
    private final BusinessUtils businessUtils;

    public ApplyForCreditsUseCaseImpl(
            RequestCreditRepositoryPort repositoryPort,
            ClientRepositoryPort clientRepositoryPort,
            BranchRepositoryPort branchRepositoryPort,
            BusinessUtils businessUtils) {
        this.repositoryPort = repositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
        this.branchRepositoryPort = branchRepositoryPort;
        this.businessUtils = businessUtils;
    }

    @Override
    public List<CreditResponse> applyCredit(int total) {
        List<Client> list = clientRepositoryPort.findAll();
        List<Branch> branchList = branchRepositoryPort.findAll();

        return IntStream.rangeClosed(1, total).mapToObj(element -> {
            BigDecimal amount = businessUtils.generateAmount();
            Long clientId = businessUtils.getRandomClientId(list);
            Long branchId = businessUtils.getRandomBranchId(branchList);

            CreditRequest request = new CreditRequest(clientId, amount, branchId);

            CreditDecision creditDecision;
            if (businessUtils.isEligible(amount)) {
                creditDecision = CreditDecision.APPROVED;
            } else {
                creditDecision = CreditDecision.REJECTED;
            }
            return repositoryPort.save(request, creditDecision);
        }).toList();
    }

}
