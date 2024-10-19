package com.adiel.prueba_tecnica_backend.domain.models;

public record ErrorResponse(Integer status, String message, Object details) {

}
