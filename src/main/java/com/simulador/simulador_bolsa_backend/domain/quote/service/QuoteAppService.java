package com.simulador.simulador_bolsa_backend.domain.quote.service;

import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;
import com.simulador.simulador_bolsa_backend.domain.quote.repository.QuoteRepository;
import com.simulador.simulador_bolsa_backend.domain.quote.usecase.CreateQuoteUseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class  QuoteAppService {

    private final CreateQuoteUseService createQuoteUseService;
    private final QuoteRepository quoteRepository;

    public QuoteAppService(CreateQuoteUseService createQuoteUseService, QuoteRepository quoteRepository) {
        this.createQuoteUseService = createQuoteUseService;
        this.quoteRepository = quoteRepository;
    }

    public Quote create(Long assetId, BigDecimal price) {
        return createQuoteUseService.execute(assetId, price);
    }

    public List<Quote> getAll() {
        return quoteRepository.findAll();  // ✅ Agora está certo
    }
}
