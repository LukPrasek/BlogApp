package pl.lukaszprasek.BlogApp.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lukaszprasek.BlogApp.domain.entities.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Integer> {
}
