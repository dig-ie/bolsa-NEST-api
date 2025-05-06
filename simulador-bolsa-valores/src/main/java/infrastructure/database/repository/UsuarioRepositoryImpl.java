package infrastructure.database.repository;

import domain.model.Usuario;
import domain.repository.UsuarioRepository;
import infrastructure.database.repository.Jpa.SpringDataUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Autowired
    private SpringDataUsuarioRepository springDataUsuarioRepository;

    @Override
    public Usuario salvar(Usuario usuario) {
        return springDataUsuarioRepository.save(usuario);
    }
    @Override
    public List<Usuario> findAll() {
        return springDataUsuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(String id) {
        return springDataUsuarioRepository.findById(id);
    }

    @Override
    public boolean existsById(String id) {
        return springDataUsuarioRepository.existsById(id);
    }

    @Override
    public void deleteById(String id) {
        springDataUsuarioRepository.deleteById(id);
    }
}
