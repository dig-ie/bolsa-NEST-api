package infrastructure.database.repository;

import domain.model.Cotacao;
import domain.repository.CotacaoRepository;
import infrastructure.database.repository.Jpa.SpringDataCotacaoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CotacaoRepositoryImpl implements CotacaoRepository {

    private final SpringDataCotacaoRepository jpaRepository;

    public CotacaoRepositoryImpl(SpringDataCotacaoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Cotacao> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Cotacao> findById(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Cotacao save(Cotacao cotacao) {
        return jpaRepository.save(cotacao);
    }

    @Override
    public void deleteById(String id) {
        jpaRepository.deleteById(id);
    }
}
