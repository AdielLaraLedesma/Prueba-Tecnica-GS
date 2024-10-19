package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.domain.models.*;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUserCase;
import com.adiel.prueba_tecnica_backend.domain.ports.out.BranchRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.ClientRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class ApplyForCreditsUseCaseImpl implements ApplyForCreditsUserCase {

    private final Random random = new Random();
    private final RequestCreditRepositoryPort repositoryPort;
    private final ClientRepositoryPort clientRepositoryPort;
    private final BranchRepositoryPort branchRepositoryPort;

    public ApplyForCreditsUseCaseImpl(
            RequestCreditRepositoryPort repositoryPort,
            ClientRepositoryPort clientRepositoryPort,
            BranchRepositoryPort branchRepositoryPort) {
        this.repositoryPort = repositoryPort;
        this.clientRepositoryPort = clientRepositoryPort;
        this.branchRepositoryPort = branchRepositoryPort;
    }

    @Override
    public List<CreditResponse> applyCredit(int total) {
        List<Client> list = clientRepositoryPort.findAll();
        List<Branch> branchList = branchRepositoryPort.findAll();

        return IntStream.rangeClosed(1, total).mapToObj(element -> {
            BigDecimal amount = this.generateAmount();
            Long clientId = this.getRandomClientId(list);
            Long branchId = this.getRandomBranchId(branchList);

            CreditRequest request = new CreditRequest(clientId, amount, branchId);

            CreditDecision creditDecision;
            if (isEligible(amount)) {
                creditDecision = CreditDecision.APPROVED;
            } else {
                creditDecision = CreditDecision.REJECTED;
            }
            return repositoryPort.save(request, creditDecision);
        }).toList();
    }

    private Long getRandomBranchId(List<Branch> branchList) {
        int anInt = random.nextInt(branchList.size());
        return branchList.get(anInt).getId();
    }

    private Long getRandomClientId(List<Client> list) {
        int anInt = random.nextInt(list.size());
        return list.get(anInt).getId();
    }

    private BigDecimal generateAmount() {
        int randomNumber = random.nextInt(10_000) + 1;
        return BigDecimal.valueOf(randomNumber);
    }

    public boolean isEligible(BigDecimal amount) {
        return amount.compareTo(BigDecimal.valueOf(5000)) <= 0;
    }
}
