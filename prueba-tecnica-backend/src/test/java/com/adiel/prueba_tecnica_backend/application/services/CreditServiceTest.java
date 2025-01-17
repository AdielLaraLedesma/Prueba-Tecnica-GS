package com.adiel.prueba_tecnica_backend.application.services;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.ApplyForCreditsUseCase;
import com.adiel.prueba_tecnica_backend.domain.ports.in.GetStatsUseCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class CreditServiceTest {

    @InjectMocks
    CreditService underTest;
    @Mock
    ApplyForCreditUseCase applyForCreditUseCase;
    @Mock
    ApplyForCreditsUseCase applyForCreditsUseCase;
    @Mock
    GetStatsUseCase getStatsUseCase;

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
    void shouldApplyCredit() {
        //Arrange
        CreditRequest request = new CreditRequest(
                1L,
                BigDecimal.ZERO,
                2L
        );

        CreditResponse expected = new CreditResponse();
        expected.setId(1L);
        expected.setClientId(2L);
        expected.setAmount(BigDecimal.ZERO);
        expected.setDecision(CreditDecision.APPROVED);
        expected.setRequestDate(LocalDateTime.now());
        expected.setBranchId(3L);

        doReturn(expected).when(applyForCreditUseCase).applyCredit(any(CreditRequest.class));

        //Act
        CreditResponse result = underTest.applyCredit(request);

        //Assert
        assertNotNull(result);
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getClientId(), result.getClientId());
        assertEquals(expected.getAmount(), result.getAmount());
        assertEquals(expected.getDecision(), result.getDecision());
        assertEquals(expected.getRequestDate(), result.getRequestDate());
        assertEquals(expected.getBranchId(), result.getBranchId());

        verify(applyForCreditUseCase).applyCredit(any(CreditRequest.class));
    }

    @Test
    void shouldGetStats(){
        //Arrange
        Map<Object, Long> expected = Map.of(
                CreditDecision.APPROVED.name(), 3L,
                CreditDecision.REJECTED.name(), 6L
        );

        doReturn(expected).when(getStatsUseCase).getStats();

        //Act
        Map<String, Long> result = underTest.getStats();

        //Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(CreditDecision.APPROVED.name()));
        assertEquals(expected.get(CreditDecision.APPROVED.name()), result.get(CreditDecision.APPROVED.name()));
        assertTrue(result.containsKey(CreditDecision.REJECTED.name()));
        assertEquals(expected.get(CreditDecision.REJECTED.name()), result.get(CreditDecision.REJECTED.name()));

        verify(getStatsUseCase).getStats();

    }

    @Test
    void shouldApplyCredit2() {
        //Arrange
        Integer request = 1;

        CreditResponse expected = new CreditResponse();
        expected.setId(1L);
        expected.setClientId(2L);
        expected.setAmount(BigDecimal.ZERO);
        expected.setDecision(CreditDecision.APPROVED);
        expected.setRequestDate(LocalDateTime.now());
        expected.setBranchId(3L);

        doReturn(List.of(expected)).when(applyForCreditsUseCase).applyCredit(anyInt());

        //Act
        List<CreditResponse> result = underTest.applyCredit(request);

        //Assert
        assertNotNull(result);
        assertEquals(expected.getId(), result.get(0).getId());
        assertEquals(expected.getClientId(), result.get(0).getClientId());
        assertEquals(expected.getAmount(), result.get(0).getAmount());
        assertEquals(expected.getDecision(), result.get(0).getDecision());
        assertEquals(expected.getRequestDate(), result.get(0).getRequestDate());
        assertEquals(expected.getBranchId(), result.get(0).getBranchId());

        verify(applyForCreditsUseCase).applyCredit(anyInt());
    }
}