package domain.repository;

import domain.model.Carteira;

import java.util.List;
import java.util.Optional;

public interface CarteiraRepository {
    Carteira salvar(Carteira carteira);
    List<Carteira> listarTodas();
    Optional<Carteira> buscarPorId(String id);
    void deletarPorId(String id);
}
