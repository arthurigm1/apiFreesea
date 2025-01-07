package br.com.arthur.br.com.arthur.Repository;

import br.com.arthur.br.com.arthur.Model.Locador;
import br.com.arthur.br.com.arthur.Model.Reserva;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReserva extends JpaRepository<Reserva, Integer> {
}
