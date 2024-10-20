package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import com.adiel.prueba_tecnica_backend.domain.models.Client;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.BranchEntity;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.ClientEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

class JpaClientRepositoryAdapterTest {

    @InjectMocks
    JpaClientRepositoryAdapter underTest;

    @Mock
    JpaClientRepository repository;

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
        ClientEntity client1 = new ClientEntity();
        client1.setFirstName("FirstName 1");
        client1.setLastName("LastName 1");
        client1.setEmail("Email 1");
        client1.setBranchId(1L);
        ClientEntity client2 = new ClientEntity();
        client1.setFirstName("FirstName 2");
        client1.setLastName("LastName 2");
        client1.setEmail("Email 2");
        client1.setBranchId(2L);


        doReturn(List.of(client1, client2)).when(repository).findAll();

        //Act
        List<Client> result = underTest.findAll();

        //Assert
        assertEquals(client1.getFirstName(), result.get(0).getFirstName());
        assertEquals(client1.getLastName(), result.get(0).getLastName());
        assertEquals(client1.getEmail(), result.get(0).getEmail());
        assertEquals(client1.getBranchId(), result.get(0).getBranchId());
        assertEquals(client2.getFirstName(), result.get(1).getFirstName());
        assertEquals(client2.getLastName(), result.get(1).getLastName());
        assertEquals(client2.getEmail(), result.get(1).getEmail());
        assertEquals(client2.getBranchId(), result.get(1).getBranchId());

        verify(repository).findAll();


    }
}