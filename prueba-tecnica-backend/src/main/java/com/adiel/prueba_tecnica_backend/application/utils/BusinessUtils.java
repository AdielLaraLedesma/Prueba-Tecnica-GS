package com.adiel.prueba_tecnica_backend.application.utils;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import com.adiel.prueba_tecnica_backend.domain.models.Client;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class BusinessUtils {

    private static final Random random = new Random();

    public boolean isEligible(BigDecimal amount) {
        return amount.compareTo(BigDecimal.valueOf(5000)) <= 0;
    }

    public Long getRandomBranchId(List<Branch> branchList) {
        int anInt = random.nextInt(branchList.size());
        return branchList.get(anInt).getId();
    }

    public Long getRandomClientId(List<Client> list) {
        int anInt = random.nextInt(list.size());
        return list.get(anInt).getId();
    }

    public BigDecimal generateAmount() {
        int randomNumber = random.nextInt(10_000) + 1;
        return BigDecimal.valueOf(randomNumber);
    }

}
