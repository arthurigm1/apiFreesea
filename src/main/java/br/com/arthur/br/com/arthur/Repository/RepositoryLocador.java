package br.com.arthur.br.com.arthur.Repository;

import br.com.arthur.br.com.arthur.Model.Embarcacao;
import br.com.arthur.br.com.arthur.Model.Locador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLocador extends JpaRepository<Locador, Integer> {
}
