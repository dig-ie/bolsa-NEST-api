package com.simulador.simulador_bolsa_backend.api.quote.controller;

import com.simulador.simulador_bolsa_backend.api.quote.dto.QuoteRequest;
import com.simulador.simulador_bolsa_backend.api.quote.dto.QuoteResponse;
import com.simulador.simulador_bolsa_backend.api.quote.mapper.QuoteMapper;
import com.simulador.simulador_bolsa_backend.domain.quote.service.QuoteAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {

    private final QuoteAppService quoteAppService;

    public QuoteController(QuoteAppService quoteAppService){
        this.quoteAppService = quoteAppService;
    }

    @PostMapping
    public ResponseEntity<QuoteResponse> create(@RequestBody QuoteRequest request) {
        var quote = quoteAppService.create(request.assetId(), request.price());
        return ResponseEntity.ok(QuoteMapper.toResponse(quote));
    }

    @GetMapping
    public ResponseEntity<List<QuoteResponse>> getAll() {
        var quotes = quoteAppService.getAll();
        var response = quotes.stream()
                .map(QuoteMapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }
}
