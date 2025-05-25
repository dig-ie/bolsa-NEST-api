package com.simulador.simulador_bolsa_backend.api.quote.dto;

import java.math.BigDecimal;

public record QuoteRequest (Long assetId, BigDecimal price){
}
