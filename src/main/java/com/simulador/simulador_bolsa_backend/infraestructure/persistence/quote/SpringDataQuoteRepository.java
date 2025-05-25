package com.simulador.simulador_bolsa_backend.infraestructure.persistence.quote;

import com.simulador.simulador_bolsa_backend.domain.quote.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataQuoteRepository extends JpaRepository<Quote,Long> {
    List<Quote> findByAssetId(Long assetId);
}
