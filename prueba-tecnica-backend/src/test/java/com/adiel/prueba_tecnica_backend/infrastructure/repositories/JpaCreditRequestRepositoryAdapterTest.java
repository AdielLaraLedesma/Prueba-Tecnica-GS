package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.CreditDecision;
import com.adiel.prueba_tecnica_backend.domain.models.CreditRequest;
import com.adiel.prueba_tecnica_backend.domain.models.CreditResponse;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.CreditRequestEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class JpaCreditRequestRepositoryAdapterTest {

    @InjectMocks
    JpaCreditRequestRepositoryAdapter underTest;

    @Mock
    JpaCreditRequestRepository repository;

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
    void shouldFindAll() {
        //Arrange
        CreditRequest request = new CreditRequest(2L, BigDecimal.TEN, 3L);
        CreditRequestEntity entity = new CreditRequestEntity();
        entity.setId(1L);
        entity.setClientId(2L);
        entity.setAmount(BigDecimal.TEN);
        entity.setBranchId(3L);
        entity.setRequestDate(LocalDateTime.now());
        entity.setStatus(CreditDecision.APPROVED.name());


        doReturn(entity).when(repository).save(any(CreditRequestEntity.class));

        //Act
        CreditResponse result = underTest.save(request, CreditDecision.APPROVED);

        //Assert
        assertEquals(entity.getId(), result.getId());
        assertEquals(entity.getClientId(), result.getClientId());
        assertEquals(entity.getAmount(), result.getAmount());
        assertEquals(entity.getBranchId(), result.getBranchId());
        assertEquals(entity.getRequestDate(), result.getRequestDate());

        verify(repository).save(any(CreditRequestEntity.class));

    }

    @Test
    void shouldFindAllEntities(){
        //Arrange
        CreditRequestEntity creditRequestEntity = new CreditRequestEntity();
        creditRequestEntity.setId(1L);
        creditRequestEntity.setClientId(2L);
        creditRequestEntity.setAmount(BigDecimal.ZERO);
        creditRequestEntity.setRequestDate(LocalDateTime.now());
        creditRequestEntity.setBranchId(3L);
        creditRequestEntity.setStatus(CreditDecision.APPROVED.name());

        doReturn(List.of(creditRequestEntity)).when(repository).findAll();

        //Act
        List<CreditResponse> result = underTest.findAll();

        //Assert
        assertNotNull(result);
        assertEquals(creditRequestEntity.getId(), result.get(0).getId());
        assertEquals(creditRequestEntity.getClientId(), result.get(0).getClientId());
        assertEquals(creditRequestEntity.getAmount(), result.get(0).getAmount());
        assertEquals(creditRequestEntity.getRequestDate(), result.get(0).getRequestDate());
        assertEquals(creditRequestEntity.getBranchId(), result.get(0).getBranchId());
        assertEquals(creditRequestEntity.getStatus(), result.get(0).getDecision().name());

        verify(repository).findAll();
    }

}