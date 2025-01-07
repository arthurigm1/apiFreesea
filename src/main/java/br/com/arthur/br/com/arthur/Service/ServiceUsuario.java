package br.com.arthur.br.com.arthur.Service;

import br.com.arthur.br.com.arthur.Model.Locador;
import br.com.arthur.br.com.arthur.Model.Locatario;
import br.com.arthur.br.com.arthur.Model.UserType;
import br.com.arthur.br.com.arthur.Model.Usuario;
import br.com.arthur.br.com.arthur.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUsuario {
    @Autowired
    private RepositoryUsuario usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario createOrUpdateUsuario(Usuario usuario) {
        if (usuario.getUserType() == UserType.LOCADOR) {
            Locador locador = new Locador();
            locador.setNome(usuario.getNome());
            locador.setCpf(usuario.getCpf());
            locador.setEmail(usuario.getEmail());
            locador.setSenha(usuario.getSenha());
            locador.setTelefone(usuario.getTelefone());
            locador.setUserType(usuario.getUserType());
            return usuarioRepository.save(locador);
        } else if (usuario.getUserType() == UserType.LOCATARIO) {
            Locatario locatario = new Locatario();
            locatario.setNome(usuario.getNome());
            locatario.setCpf(usuario.getCpf());
            locatario.setEmail(usuario.getEmail());
            locatario.setSenha(usuario.getSenha());
            locatario.setTelefone(usuario.getTelefone());
            locatario.setUserType(usuario.getUserType());
            return usuarioRepository.save(locatario);
        } else {
            return usuarioRepository.save(usuario);
        }
    }

    public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }
}
