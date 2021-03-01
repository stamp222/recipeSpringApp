package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.Recipe;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {
}
