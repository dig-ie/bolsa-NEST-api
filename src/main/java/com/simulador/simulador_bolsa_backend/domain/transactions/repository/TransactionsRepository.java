package com.simulador.simulador_bolsa_backend.domain.transactions.repository;

import java.util.List;
import java.util.Optional;

import com.simulador.simulador_bolsa_backend.domain.transactions.model.Transactions;

public interface TransactionsRepository {

    Transactions save(Transactions transaction);

    Optional<Transactions> findById(Long id);

    List<Transactions> findAll();

    void deleteById(Long id);

}
