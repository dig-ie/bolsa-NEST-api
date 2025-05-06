package domain.service;

import domain.model.Transacao;
import domain.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;

    public Transacao salvar(Transacao transacao) {
        return transacaoRepository.salvar(transacao);
    }

    public Optional<Transacao> buscarPorId(String id) {
        return transacaoRepository.buscarPorId(id);
    }

    public List<Transacao> listarTodos() {
        return transacaoRepository.listarTodos();
    }

    public void deletarPorId(String id) {
        transacaoRepository.deletarPorId(id);
    }
}