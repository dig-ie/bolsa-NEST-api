package infrastructure.database.repository.Jpa;

import domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import domain.repository.UsuarioRepository;

import java.util.Optional;

@Repository
public interface SpringDataUsuarioRepository extends JpaRepository<Usuario, String>, UsuarioRepository {
    Optional<Usuario> findById(String id);

    boolean existsById(String id);

    void deleteById(String id);

    // Customizações, se necessário, podem ser feitas aqui
}
