package domain.service;

import domain.model.Ativo;
import domain.repository.AtivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public Ativo salvar(Ativo ativo) {
        return ativoRepository.salvar(ativo);
    }

    public List<Ativo> listarTodos() {
        return ativoRepository.listarTodos();
    }

    public Optional<Ativo> buscarPorId(String id) {
        return ativoRepository.buscarPorId(id);
    }

    public void deletarPorId(String id) {
        ativoRepository.deletarPorId(id);
    }
}
