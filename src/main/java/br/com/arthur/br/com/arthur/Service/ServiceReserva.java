package br.com.arthur.br.com.arthur.Service;

import br.com.arthur.br.com.arthur.Model.Embarcacao;
import br.com.arthur.br.com.arthur.Model.Reserva;
import br.com.arthur.br.com.arthur.Repository.RepositoryEmbarcacao;
import br.com.arthur.br.com.arthur.Repository.RepositoryReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceReserva {

    @Autowired
    private RepositoryReserva repositoryReserva;

    public List<Reserva> getAllUsuarios() {
        return repositoryReserva.findAll();
    }

    public Reserva getUsuarioById(Integer id) {
        return repositoryReserva.findById(id).orElse(null);
    }

    public Reserva createOrUpdateUsuario(Reserva reserva) {

        return repositoryReserva.save(reserva);
    }


    public void deleteUsuario(Reserva reserva) {
        repositoryReserva.delete(reserva);
    }
}
