package com.adiel.prueba_tecnica_backend.domain.ports.in;

import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

import java.util.List;

public interface ApplyForCreditsUseCase {

    List<CreditResponse> applyCredit(int total);

}
