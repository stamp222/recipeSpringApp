package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository <Category, Long> {

    Optional<Category> findByDescription(String description);
}
