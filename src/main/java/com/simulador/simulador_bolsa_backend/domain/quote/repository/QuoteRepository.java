package com.simulador.simulador_bolsa_backend.domain.quote.repository;

import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;

import java.util.List;

public interface QuoteRepository  {

    Quote save(Quote quote);
    List<Quote> findByAssetId(Long assetId);
    List<Quote> findAll();
}
