package com.simulador.simulador_bolsa_backend.domain.quote.usecase;

import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;
import com.simulador.simulador_bolsa_backend.domain.quote.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Objects;

@Service
public class CreateQuoteUseService {

    private final QuoteRepository quoteRepository;

    public CreateQuoteUseService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    public Quote execute(long assetId, BigDecimal price){

        Objects.requireNonNull(assetId, "Asset ID cannot be null");
        Objects.requireNonNull(price, "Price cannot be null");

        Quote quote = new Quote(assetId, price);

        if (!quote.isPricePositive()){
            throw new IllegalArgumentException("Price must be positive");
        }
        return quoteRepository.save(quote);
    }
}
