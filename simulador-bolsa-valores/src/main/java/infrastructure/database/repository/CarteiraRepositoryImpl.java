package infrastructure.database.repository;

import domain.model.Carteira;
import domain.repository.CarteiraRepository;
import infrastructure.database.repository.Jpa.SpringDataCarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarteiraRepositoryImpl implements CarteiraRepository {

    private final SpringDataCarteiraRepository springDataCarteiraRepository;

    @Override
    public Carteira salvar(Carteira carteira) {
        return springDataCarteiraRepository.save(carteira);
    }

    @Override
    public List<Carteira> listarTodas() {
        return springDataCarteiraRepository.findAll();
    }

    @Override
    public Optional<Carteira> buscarPorId(String id) {
        return springDataCarteiraRepository.findById(id);
    }

    @Override
    public void deletarPorId(String id) {
        springDataCarteiraRepository.deleteById(id);
    }
}
