package com.simulador.simulador_bolsa_backend.infraestructure.persistence.quote;

import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;
import com.simulador.simulador_bolsa_backend.domain.quote.repository.QuoteRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class QuoteRepositoryImpl implements QuoteRepository {

    private final SpringDataQuoteRepository springDataQuoteRepository;

    public QuoteRepositoryImpl(SpringDataQuoteRepository springDataQuoteRepository){
        this.springDataQuoteRepository = springDataQuoteRepository;
    }

    @Override
    public Quote save(Quote quote){
        return springDataQuoteRepository.save(quote);
    }

    @Override
    public List<Quote> findAll() {
        return springDataQuoteRepository.findAll();
    }

    @Override
    public List<Quote> findByAssetId(Long assetId) {
        return springDataQuoteRepository.findByAssetId(assetId);
    }
}
