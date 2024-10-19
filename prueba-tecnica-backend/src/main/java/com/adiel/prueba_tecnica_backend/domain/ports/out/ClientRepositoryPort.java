package com.adiel.prueba_tecnica_backend.domain.ports.out;

import com.adiel.prueba_tecnica_backend.domain.models.Client;

import java.util.List;

public interface ClientRepositoryPort {

    List<Client> findAll();

}
