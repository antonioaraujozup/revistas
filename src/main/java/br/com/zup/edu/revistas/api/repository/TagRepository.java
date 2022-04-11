package br.com.zup.edu.revistas.api.repository;

import br.com.zup.edu.revistas.api.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
