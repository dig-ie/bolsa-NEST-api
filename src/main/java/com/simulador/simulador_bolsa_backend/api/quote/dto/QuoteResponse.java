package com.simulador.simulador_bolsa_backend.api.quote.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record QuoteResponse (Long id, Long aseetId, BigDecimal price, LocalDateTime timestamp){
}
