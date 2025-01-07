package br.com.arthur.br.com.arthur.Repository;

import br.com.arthur.br.com.arthur.Model.Locatario;
import br.com.arthur.br.com.arthur.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLocatario extends JpaRepository<Locatario, Integer> {
}
