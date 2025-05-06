package infrastructure.database.repository.Jpa;

import domain.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataTransacaoRepository extends JpaRepository<Transacao, String> {
}