package com.adiel.prueba_tecnica_backend.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class CreditRequestDTO {

    @NotNull(message = "El id del cliente no puede ser nulo")
    @Positive(message = "El id del cliente tiene que ser positivo")
    private Long clientId;

    @NotNull(message = "El importe no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El importe debe de ser mayor a cero")
    private BigDecimal amount;

    @NotNull(message = "El id de la sucursal no puede ser nulo")
    @Positive(message = "El id de la sucursal debe de ser positivo")
    private Long branchId;

    public CreditRequestDTO() {
    }

    public CreditRequestDTO(Long clientId, BigDecimal amount, Long branchId) {
        this.clientId = clientId;
        this.amount = amount;
        this.branchId = branchId;
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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

}
