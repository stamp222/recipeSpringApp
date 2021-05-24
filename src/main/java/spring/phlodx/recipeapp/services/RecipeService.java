package spring.phlodx.recipeapp.services;


import org.springframework.stereotype.Service;
import spring.phlodx.recipeapp.commands.RecipeCommand;
import spring.phlodx.recipeapp.domain.Recipe;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
