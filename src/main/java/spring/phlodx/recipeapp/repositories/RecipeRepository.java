package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.Recipe;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository <Recipe, Long> {
//    Optional<Recipe> findByRecipe()
}
