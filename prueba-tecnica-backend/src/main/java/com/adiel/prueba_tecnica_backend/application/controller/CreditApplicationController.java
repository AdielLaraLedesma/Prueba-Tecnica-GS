package com.adiel.prueba_tecnica_backend.application.controller;

import com.adiel.prueba_tecnica_backend.application.dto.CreditRequestDTO;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping(value = "/api/credit")
public class CreditApplicationController {

    /*@PostMapping
    public String applyForCredit(@Valid @RequestBody CreditRequestDTO dto){
        CreditRequest creditRequest = new CreditRequest(dto.getId(), dto.getAmount(), dto.getClient());
        service.processCreditRequest(creditRequest);
        return creditRequest.getDecision().name();
    }*/

}
