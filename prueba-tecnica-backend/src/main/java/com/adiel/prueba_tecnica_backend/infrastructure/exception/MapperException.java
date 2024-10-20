package com.adiel.prueba_tecnica_backend.infrastructure.exception;

import com.adiel.prueba_tecnica_backend.domain.models.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MapperException {

    public static final Integer STATUS_400 = 400;
    public static final Integer STATUS_409 = 409;
    public static final String MESSAGE_400 = "Request invalido. Favor de validar los datos enviados.";
    public static final String MESSAGE_409 = "El recurso relacionado no existe. Favor de verificar los datos enviados.";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse(
                STATUS_400,
                MESSAGE_400,
                errors);
        return ResponseEntity.status(STATUS_400).body(errorResponse);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        ErrorResponse errorResponse = new ErrorResponse(
                STATUS_409,
                MESSAGE_409,
                ex.getMessage());
        return ResponseEntity.status(STATUS_409).body(errorResponse);

    }


}
