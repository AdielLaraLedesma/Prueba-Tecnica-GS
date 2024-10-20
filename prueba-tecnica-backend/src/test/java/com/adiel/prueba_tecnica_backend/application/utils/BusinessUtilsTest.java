package com.adiel.prueba_tecnica_backend.application.utils;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import com.adiel.prueba_tecnica_backend.domain.models.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BusinessUtilsTest {

    @InjectMocks
    BusinessUtils underTest;

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
    void shouldReturnFalseIsNotEligible() {
        //Arrange
        BigDecimal amount = BigDecimal.valueOf(7000);

        //Act
        boolean result = underTest.isEligible(amount);

        //Assert
        assertFalse(result);

    }

    @Test
    void shouldReturnFalseIsEligible() {
        //Arrange
        BigDecimal amount = BigDecimal.valueOf(10);

        //Act
        boolean result = underTest.isEligible(amount);

        //Assert
        assertTrue(result);

    }

    @Test
    void shouldGetTheBranchIdRandomly() {
        //Arrange
        Branch branch = new Branch();
        branch.setId(1L);

        //Act
        Long result = underTest.getRandomBranchId(List.of(branch));

        //Assert
        assertNotNull(result);
        assertEquals(branch.getId(), result);


    }

    @Test
    void shouldGetTheClientIdRandomly() {
        //Arrange
        Client client = new Client();
        client.setId(1L);

        //Act
        Long result = underTest.getRandomClientId(List.of(client));

        //Assert
        assertNotNull(result);
        assertEquals(client.getId(), result);

    }

    @Test
    void shouldGenerateAmountRandomly() {
        //Arrange

        //Act
        BigDecimal result = underTest.generateAmount();

        //Assert
        assertNotNull(result);

    }
}