package domain.service;

import domain.model.Usuario;
import domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    // Buscar todos os usuários
    public List<Usuario> buscarTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuário por ID
    public Optional<Usuario> buscarUsuarioPorId(String id) {
        return usuarioRepository.findById(id);
    }

    // Atualizar usuário
    public Usuario atualizarUsuario(String id, Usuario usuarioAtualizado) {
        if (usuarioRepository.existsById(id)) {
            usuarioAtualizado.setId(id);
            return usuarioRepository.salvar(usuarioAtualizado);
        }
        return null;  // Ou lançar exceção
    }

    // Deletar usuário
    public boolean deletarUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
