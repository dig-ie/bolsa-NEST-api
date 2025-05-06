package infrastructure.database.repository.Jpa;

import domain.model.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAtivoRepository extends JpaRepository<Ativo, String> {
}
