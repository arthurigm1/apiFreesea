package br.com.arthur.br.com.arthur.Service;

import br.com.arthur.br.com.arthur.Model.Locador;
import br.com.arthur.br.com.arthur.Repository.RepositoryLocador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLocador {

    @Autowired
    private RepositoryLocador repositoryLocador;

    public List<Locador> listarLocadores() {
        return repositoryLocador.findAll();
    }

    public Locador salvarLocador(Locador locador) {
        return repositoryLocador.save(locador);
    }

    public Locador getLocadorById(Integer id) {
        return repositoryLocador.findById(id).orElse(null);
    }
}
