package domain.repository;

import domain.model.Transacao;

import java.util.List;
import java.util.Optional;

public interface TransacaoRepository {
    Transacao salvar(Transacao transacao);
    Optional<Transacao> buscarPorId(String id);
    List<Transacao> listarTodos();
    void deletarPorId(String id);
}
