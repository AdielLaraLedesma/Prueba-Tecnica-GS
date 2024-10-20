package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.application.utils.BusinessUtils;
import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ApplyForCreditUseCaseImplTest {

    @InjectMocks
    ApplyForCreditUseCaseImpl underTest;

    @Mock
    BusinessUtils businessUtils;
    @Mock
    RequestCreditRepositoryPort repositoryPort;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        if(closeable != null){
            closeable.close();
        }
    }

    @Test
    void shouldApplyForACreditAndGetApproved() {
        //Arrange
        CreditResponse response = new CreditResponse();
        response.setId(1L);
        response.setClientId(2L);
        response.setAmount(BigDecimal.ONE);
        response.setDecision(CreditDecision.APPROVED);
        response.setRequestDate(LocalDateTime.now());
        response.setBranchId(3L);

        CreditRequest request = new CreditRequest(
                1L,
                BigDecimal.ONE,
                2L);

        doReturn(true).when(businessUtils).isEligible(any(BigDecimal.class));
        doReturn(response).when(repositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

        //Act
        CreditResponse result = underTest.applyCredit(request);

        //Assert
        assertNotNull(result);
        assertEquals(response.getId(), result.getId());
        assertEquals(response.getClientId(), result.getClientId());
        assertEquals(response.getAmount(), result.getAmount());
        assertEquals(response.getDecision(), result.getDecision());
        assertEquals(response.getRequestDate(), result.getRequestDate());
        assertEquals(response.getBranchId(), result.getBranchId());

        verify(businessUtils).isEligible(any(BigDecimal.class));
        verify(repositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

    }

    @Test
    void shouldApplyForACreditAndGetRejected() {
        //Arrange
        CreditResponse response = new CreditResponse();
        response.setId(1L);
        response.setClientId(2L);
        response.setAmount(BigDecimal.ONE);
        response.setDecision(CreditDecision.REJECTED);
        response.setRequestDate(LocalDateTime.now());
        response.setBranchId(3L);

        CreditRequest request = new CreditRequest(
                1L,
                BigDecimal.ONE,
                2L);

        doReturn(false).when(businessUtils).isEligible(any(BigDecimal.class));
        doReturn(response).when(repositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

        //Act
        CreditResponse result = underTest.applyCredit(request);

        //Assert
        assertNotNull(result);
        assertEquals(response.getId(), result.getId());
        assertEquals(response.getClientId(), result.getClientId());
        assertEquals(response.getAmount(), result.getAmount());
        assertEquals(response.getDecision(), result.getDecision());
        assertEquals(response.getRequestDate(), result.getRequestDate());
        assertEquals(response.getBranchId(), result.getBranchId());

        verify(businessUtils).isEligible(any(BigDecimal.class));
        verify(repositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

    }

}