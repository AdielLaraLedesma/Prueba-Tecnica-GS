package com.adiel.prueba_tecnica_backend.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditResponse {

    private Long id;
    private Client client;
    private BigDecimal amount;
    private LocalDateTime requestDate;
    private CreditDecision decision;
    private Branch branch;

    public CreditResponse() {
    }

    public CreditResponse(
            Long id,
            Client client,
            BigDecimal amount,
            LocalDateTime requestDate,
            CreditDecision decision,
            Branch branch) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.requestDate = requestDate;
        this.decision = decision;
        this.branch = branch;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public CreditDecision getDecision() {
        return decision;
    }

    public void setDecision(CreditDecision decision) {
        this.decision = decision;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
