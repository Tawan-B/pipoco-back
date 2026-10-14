package com.tawan.pipoco.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawan.pipoco.Entidades.Usuario;
import com.tawan.pipoco.Repositorios.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> listarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    public Usuario criarUsuario(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> atualizarUsuario(String id, Usuario usuario) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        });
    }

    public boolean deletarUsuario(String id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }
}
