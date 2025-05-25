package com.simulador.simulador_bolsa_backend.api.quote.mapper;

import com.simulador.simulador_bolsa_backend.api.quote.dto.QuoteResponse;
import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;

public class QuoteMapper {

    public static QuoteResponse toResponse(Quote quote){
        return new QuoteResponse(
                quote.getId(),
                quote.getAssetId(),
                quote.getPrice(),
                quote.getTimestamp()
        );
    }
}

