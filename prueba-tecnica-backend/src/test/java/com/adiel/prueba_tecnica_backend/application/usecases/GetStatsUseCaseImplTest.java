package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class GetStatsUseCaseImplTest {

    @InjectMocks
    GetStatsUseCaseImpl underTest;
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
    void shouldGetStats() {
        //Arrange
        CreditResponse creditResponse1 = new CreditResponse();
        creditResponse1.setDecision(CreditDecision.APPROVED);
        CreditResponse creditResponse2 = new CreditResponse();
        creditResponse2.setDecision(CreditDecision.APPROVED);
        CreditResponse creditResponse3 = new CreditResponse();
        creditResponse3.setDecision(CreditDecision.REJECTED);

        doReturn(List.of(creditResponse1, creditResponse2, creditResponse3)).when(repositoryPort).findAll();

        //Act
        Map<String, Long> result = underTest.getStats();

        //Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.containsKey(CreditDecision.APPROVED.name().toLowerCase()));
        assertEquals(2, result.get(CreditDecision.APPROVED.name().toLowerCase()));
        assertTrue(result.containsKey(CreditDecision.REJECTED.name().toLowerCase()));
        assertEquals(1, result.get(CreditDecision.REJECTED.name().toLowerCase()));


        verify(repositoryPort).findAll();

    }

}