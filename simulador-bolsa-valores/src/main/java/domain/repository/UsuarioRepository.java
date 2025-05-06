package domain.repository;

import domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    List<Usuario> findAll();
    Optional<Usuario> findById(String id);
    boolean existsById(String id);
    void deleteById(String id);
}
