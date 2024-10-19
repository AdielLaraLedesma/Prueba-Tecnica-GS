package com.adiel.prueba_tecnica_backend.infrastructure.controllers;

import com.adiel.prueba_tecnica_backend.application.services.CreditService;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/credit")
public class CreditRequestController {

    private final CreditService creditService;

    public CreditRequestController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public ResponseEntity<CreditResponse> applyCredit(@Valid @RequestBody CreditRequest request){
        CreditResponse response = creditService.applyCredit(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping(path = "/simulate")
    public ResponseEntity<List<CreditResponse>> applyCredits(@PathParam("total") Integer total){
        System.out.println("Total " + total);
        List<CreditResponse> response = creditService.applyCredit(total);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}