package br.com.zup.edu.revistas.api.repository;

import br.com.zup.edu.revistas.api.model.Revista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevistaRepository extends JpaRepository<Revista, Long> {
}
