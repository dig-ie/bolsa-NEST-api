package infrastructure.database.repository.Jpa;

import domain.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCarteiraRepository extends JpaRepository<Carteira, String> {
}
