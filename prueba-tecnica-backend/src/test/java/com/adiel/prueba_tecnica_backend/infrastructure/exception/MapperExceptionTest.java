package com.adiel.prueba_tecnica_backend.infrastructure.exception;

import com.adiel.prueba_tecnica_backend.domain.models.ErrorResponse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Map;

import static com.adiel.prueba_tecnica_backend.infrastructure.exception.MapperException.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MapperExceptionTest {

    @InjectMocks
    MapperException underTest;

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
    void shouldReturn400Status() {
        //Arrange
        String clientId = "clientId";
        String message = "El id del cliente no puede ser nulo";

        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);
        FieldError fieldError = mock(FieldError.class);

        doReturn(clientId).when(fieldError).getField();
        doReturn(message).when(fieldError).getDefaultMessage();
        doReturn(List.of(fieldError)).when(bindingResult).getAllErrors();
        doReturn(bindingResult).when(exception).getBindingResult();

        //Act
        ResponseEntity<ErrorResponse> result = underTest.handleValidationExceptions(exception);

        //Assert
        assertEquals(STATUS_400, result.getStatusCode().value());

        assertEquals(STATUS_400, result.getBody().status());
        assertEquals(MESSAGE_400, result.getBody().message());

        Map<String, String> map = (Map<String, String>) result.getBody().details();

        assertTrue(map.containsKey(clientId));
        assertTrue(map.containsValue(message));

        verify(fieldError).getField();
        verify(fieldError).getDefaultMessage();
        verify(bindingResult).getAllErrors();
        verify(exception).getBindingResult();

    }

    @Test
    void shouldReturn409Status() {
        //Arrange
        String message = "Message";
        DataIntegrityViolationException exception = new DataIntegrityViolationException(message);

        //Act
        ResponseEntity<ErrorResponse> result = underTest.handleDataIntegrityViolationException(exception);

        //Assert
        assertEquals(STATUS_409, result.getStatusCode().value());

        assertEquals(STATUS_409, result.getBody().status());
        assertEquals(MESSAGE_409, result.getBody().message());
        assertEquals(message, result.getBody().details());


    }
}