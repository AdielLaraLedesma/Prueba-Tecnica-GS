package com.adiel.prueba_tecnica_backend.domain.ports.in;

import java.util.Map;

public interface GetStatsUseCase {

    Map<String, Long> getStats();

}
