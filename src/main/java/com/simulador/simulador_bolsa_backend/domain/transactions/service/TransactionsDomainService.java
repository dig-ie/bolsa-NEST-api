package com.simulador.simulador_bolsa_backend.domain.transactions.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import com.simulador.simulador_bolsa_backend.domain.transactions.model.Transactions;
import com.simulador.simulador_bolsa_backend.domain.transactions.repository.TransactionsRepository;

public class TransactionsDomainService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsDomainService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    public Transactions createTransaction(
            UUID userId,
            UUID assentId,
            Transactions.Type type,
            BigDecimal unitPrice,
            int quantity,
            LocalDateTime timestamp
    ) {
        BigDecimal total = unitPrice.multiply(BigDecimal.valueOf(quantity));
        Transactions transaction = new Transactions.Builder()
                .id(UUID.randomUUID())
                .userId(userId)
                .assentId(assentId)
                .type(type)
                .unitePrice(unitPrice)
                .quantity(quantity)
                .total(total)
                .timestamp(timestamp)
                .build();
        return transactionsRepository.save(transaction);
    }
}

