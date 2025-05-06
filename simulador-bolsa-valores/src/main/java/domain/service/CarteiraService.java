package domain.service;

import domain.model.Carteira;
import domain.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;

    public Carteira salvar(Carteira carteira) {
        return carteiraRepository.salvar(carteira);
    }

    public List<Carteira> listarTodas() {
        return carteiraRepository.listarTodas();
    }

    public Optional<Carteira> buscarPorId(String id) {
        return carteiraRepository.buscarPorId(id);
    }

    public void deletarPorId(String id) {
        carteiraRepository.deletarPorId(id);
    }
}
