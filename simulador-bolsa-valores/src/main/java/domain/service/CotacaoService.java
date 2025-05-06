package domain.service;

import domain.model.Cotacao;
import domain.repository.CotacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CotacaoService {

    private final CotacaoRepository cotacaoRepository;

    public Cotacao salvar(Cotacao cotacao) {
        return cotacaoRepository.save(cotacao);
    }

    public Optional<Cotacao> buscarPorId(String id) {
        return cotacaoRepository.findById(id);
    }

    public List<Cotacao> listarTodos() {
        return cotacaoRepository.findAll();
    }

    public void deletarPorId(String id) {
        cotacaoRepository.deleteById(id);
    }
}
