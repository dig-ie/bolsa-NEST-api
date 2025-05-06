package infrastructure.database.repository;


import domain.model.Transacao;
import domain.repository.TransacaoRepository;
import infrastructure.database.repository.Jpa.SpringDataTransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TransacaoRepositoryImpl implements TransacaoRepository {

    private final SpringDataTransacaoRepository springDataTransacaoRepository;

    @Override
    public Transacao salvar(Transacao transacao) {
        return springDataTransacaoRepository.save(transacao);
    }

    @Override
    public Optional<Transacao> buscarPorId(String id) {
        return springDataTransacaoRepository.findById(id);
    }

    @Override
    public List<Transacao> listarTodos() {
        return springDataTransacaoRepository.findAll();
    }

    @Override
    public void deletarPorId(String id) {
        springDataTransacaoRepository.deleteById(id);
    }
}