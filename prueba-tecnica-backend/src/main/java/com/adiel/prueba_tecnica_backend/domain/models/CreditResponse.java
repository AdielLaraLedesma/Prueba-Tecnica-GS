package com.adiel.prueba_tecnica_backend.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditResponse {

    private Long id;
    private Long clientId;
    private BigDecimal amount;
    private LocalDateTime requestDate;
    private CreditDecision decision;
    private Long branchId;

    public CreditResponse() {
    }

    public CreditResponse(
            Long id,
            Long clientId,
            BigDecimal amount,
            LocalDateTime requestDate,
            CreditDecision decision,
            Long branchId) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.requestDate = requestDate;
        this.decision = decision;
        this.branchId = branchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
