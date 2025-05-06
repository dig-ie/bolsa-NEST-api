package infrastructure.database.repository.Jpa;

import domain.model.Cotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCotacaoRepository extends JpaRepository<Cotacao, String> {
}
