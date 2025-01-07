package br.com.arthur.br.com.arthur.Repository;

import br.com.arthur.br.com.arthur.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<Usuario, Integer> {
}
