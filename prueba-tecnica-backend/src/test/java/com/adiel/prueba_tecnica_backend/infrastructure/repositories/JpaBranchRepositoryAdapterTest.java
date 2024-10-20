package com.adiel.prueba_tecnica_backend.infrastructure.repositories;

import com.adiel.prueba_tecnica_backend.domain.models.Branch;
import com.adiel.prueba_tecnica_backend.infrastructure.entities.BranchEntity;
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

class JpaBranchRepositoryAdapterTest {

    @InjectMocks
    JpaBranchRepositoryAdapter underTest;

    @Mock
    JpaBranchRepository repository;

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
        BranchEntity branch1 = new BranchEntity();
        branch1.setName("Nombre 1");
        branch1.setAddress("Direccion 1");
        BranchEntity branch2 = new BranchEntity();
        branch2.setName("Nombre 2");
        branch2.setAddress("Direccion 2");


        doReturn(List.of(branch1, branch2)).when(repository).findAll();

        //Act
        List<Branch> result = underTest.findAll();

        //Assert
        assertEquals(branch1.getName(), result.get(0).getName());
        assertEquals(branch1.getAddress(), result.get(0).getAddress());
        assertEquals(branch2.getName(), result.get(1).getName());
        assertEquals(branch2.getAddress(), result.get(1).getAddress());

        verify(repository).findAll();


    }
}