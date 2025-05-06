package domain.repository;

import domain.model.Ativo;

import java.util.List;
import java.util.Optional;

public interface AtivoRepository {
    Ativo salvar(Ativo ativo);
    List<Ativo> listarTodos();
    Optional<Ativo> buscarPorId(String id);
    void deletarPorId(String id);
}
