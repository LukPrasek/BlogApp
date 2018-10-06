package pl.lukaszprasek.BlogApp.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lukaszprasek.BlogApp.domain.entities.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Integer> {
}
