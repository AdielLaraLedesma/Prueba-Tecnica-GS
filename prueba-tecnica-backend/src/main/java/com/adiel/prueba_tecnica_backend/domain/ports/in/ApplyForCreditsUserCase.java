package com.adiel.prueba_tecnica_backend.domain.ports.in;

import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;

import java.util.List;

public interface ApplyForCreditsUserCase {

    List<CreditResponse> applyCredit(int total);

}
