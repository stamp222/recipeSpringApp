package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.Category;

public interface CategoryRepository extends CrudRepository <Category, Long> {
}
