package com.adiel.prueba_tecnica_backend.infrastructure.entities;

import com.adiel.prueba_tecnica_backend.domain.models.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "CreditRequest")
public class CreditRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "ClientId")
    private Long clientId;
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "RequestDate")
    @CreationTimestamp
    private LocalDateTime requestDate;
    @Column(name = "Status")
    private String status;
    @Column(name = "BranchId")
    private Long branchId;

    public CreditRequestEntity() {
    }

    public CreditRequestEntity(Long clientId, BigDecimal amount, String status, Long branchId) {
        this.clientId = clientId;
        this.amount = amount;
        this.status = status;
        this.branchId = branchId;
    }

    public static CreditRequestEntity fromDomainModel(CreditRequest creditRequest, CreditDecision decision){
        return new CreditRequestEntity(
                creditRequest.getClientId(),
                creditRequest.getAmount(),
                decision.name(),
                creditRequest.getBranchId()
        );
    }

    public CreditResponse toDomainModel(){
        return new CreditResponse(
                id,
                clientId,
                amount,
                requestDate,
                CreditDecision.valueOf(status),
                branchId
                );
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "CreditRequestEntity{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", amount=" + amount +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", branchId=" + branchId +
                '}';
    }
}
