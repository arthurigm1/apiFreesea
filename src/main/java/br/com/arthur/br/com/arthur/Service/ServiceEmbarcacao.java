package br.com.arthur.br.com.arthur.Service;

import br.com.arthur.br.com.arthur.Model.*;
import br.com.arthur.br.com.arthur.Repository.RepositoryEmbarcacao;
import br.com.arthur.br.com.arthur.Repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEmbarcacao {
    @Autowired
    private RepositoryEmbarcacao repositoryEmbarcacao;

    public List<Embarcacao> getAllUsuarios() {
        return repositoryEmbarcacao.findAll();
    }

    public Embarcacao getUsuarioById(Integer id) {
        return repositoryEmbarcacao.findById(id).orElse(null);
    }

    public Embarcacao createOrUpdateUsuario(Embarcacao embarcacao) {

            return repositoryEmbarcacao.save(embarcacao);
        }


    public void deleteUsuario(Embarcacao embarcacao) {
        repositoryEmbarcacao.delete(embarcacao);
    }
}

