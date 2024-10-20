package com.adiel.prueba_tecnica_backend.application.usecases;

import com.adiel.prueba_tecnica_backend.application.utils.BusinessUtils;
import com.adiel.prueba_tecnica_backend.domain.models.*;
import com.adiel.prueba_tecnica_backend.domain.ports.out.BranchRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.ClientRepositoryPort;
import com.adiel.prueba_tecnica_backend.domain.ports.out.RequestCreditRepositoryPort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class ApplyForCreditsUseCaseImplTest {

    @InjectMocks
    ApplyForCreditsUseCaseImpl underTest;

    @Mock
    ClientRepositoryPort clientRepositoryPort;
    @Mock
    BranchRepositoryPort branchRepositoryPort;
    @Mock
    BusinessUtils businessUtils;
    @Mock
    RequestCreditRepositoryPort requestCreditRepositoryPort;

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
    void shouldApplyForACreditButGetRejected() {
        //Arrange
        CreditResponse expected = new CreditResponse(
                1L,
                2L,
                BigDecimal.ONE,
                LocalDateTime.now(),
                CreditDecision.REJECTED,
                3L
        );

        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Firstname");
        client.setLastName("Lastname");
        client.setEmail("Email");
        client.setBranchId(2L);

        Branch branch = new Branch();
        branch.setId(1L);
        branch.setName("Name");
        branch.setAddress("Address");

        doReturn(List.of(client)).when(clientRepositoryPort).findAll();
        doReturn(List.of(branch)).when(branchRepositoryPort).findAll();
        doReturn(BigDecimal.ONE).when(businessUtils).generateAmount();
        doReturn(1L).when(businessUtils).getRandomClientId(anyList());
        doReturn(2L).when(businessUtils).getRandomBranchId(anyList());
        doReturn(true).when(businessUtils).isEligible(any(BigDecimal.class));
        doReturn(expected).when(requestCreditRepositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

        //Act
        List<CreditResponse> result = underTest.applyCredit(1);

        //Assert
        assertNotNull(result);
        assertEquals(expected.getId(), result.get(0).getId());
        assertEquals(expected.getClientId(), result.get(0).getClientId());
        assertEquals(expected.getAmount(), result.get(0).getAmount());
        assertEquals(expected.getRequestDate(), result.get(0).getRequestDate());
        assertEquals(expected.getDecision(), result.get(0).getDecision());
        assertEquals(expected.getBranchId(), result.get(0).getBranchId());

        verify(clientRepositoryPort).findAll();
        verify(branchRepositoryPort).findAll();
        verify(businessUtils).generateAmount();
        verify(businessUtils).getRandomClientId(anyList());
        verify(businessUtils).getRandomBranchId(anyList());
        verify(businessUtils).isEligible(any(BigDecimal.class));
        verify(requestCreditRepositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

    }


    @Test
    void shouldApplyForACreditButGetApproved() {
        //Arrange
        CreditResponse expected = new CreditResponse(
                1L,
                2L,
                BigDecimal.ONE,
                LocalDateTime.now(),
                CreditDecision.APPROVED,
                3L
        );

        Client client = new Client();
        client.setId(1L);
        client.setFirstName("Firstname");
        client.setLastName("Lastname");
        client.setEmail("Email");
        client.setBranchId(2L);

        Branch branch = new Branch();
        branch.setId(1L);
        branch.setName("Name");
        branch.setAddress("Address");

        doReturn(List.of(client)).when(clientRepositoryPort).findAll();
        doReturn(List.of(branch)).when(branchRepositoryPort).findAll();
        doReturn(BigDecimal.ONE).when(businessUtils).generateAmount();
        doReturn(1L).when(businessUtils).getRandomClientId(anyList());
        doReturn(2L).when(businessUtils).getRandomBranchId(anyList());
        doReturn(false).when(businessUtils).isEligible(any(BigDecimal.class));
        doReturn(expected).when(requestCreditRepositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

        //Act
        List<CreditResponse> result = underTest.applyCredit(1);

        //Assert
        assertNotNull(result);
        assertEquals(expected.getId(), result.get(0).getId());
        assertEquals(expected.getClientId(), result.get(0).getClientId());
        assertEquals(expected.getAmount(), result.get(0).getAmount());
        assertEquals(expected.getRequestDate(), result.get(0).getRequestDate());
        assertEquals(expected.getDecision(), result.get(0).getDecision());
        assertEquals(expected.getBranchId(), result.get(0).getBranchId());

        verify(clientRepositoryPort).findAll();
        verify(branchRepositoryPort).findAll();
        verify(businessUtils).generateAmount();
        verify(businessUtils).getRandomClientId(anyList());
        verify(businessUtils).getRandomBranchId(anyList());
        verify(businessUtils).isEligible(any(BigDecimal.class));
        verify(requestCreditRepositoryPort).save(any(CreditRequest.class), any(CreditDecision.class));

    }

}