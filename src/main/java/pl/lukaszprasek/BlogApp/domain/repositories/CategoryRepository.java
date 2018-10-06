package pl.lukaszprasek.BlogApp.domain.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lukaszprasek.BlogApp.domain.entities.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
    Optional<CategoryEntity> findByName(String name);
    List<CategoryEntity> findAll();
}
