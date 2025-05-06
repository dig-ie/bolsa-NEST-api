package domain.repository;

import domain.model.Cotacao;

import java.util.List;
import java.util.Optional;

public interface CotacaoRepository {
    List<Cotacao> findAll();
    Optional<Cotacao> findById(String id);
    Cotacao save(Cotacao cotacao);
    void deleteById(String id);
}
