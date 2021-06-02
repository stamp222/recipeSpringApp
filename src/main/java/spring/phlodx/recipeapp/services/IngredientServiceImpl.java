package spring.phlodx.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.phlodx.recipeapp.commands.IngredientCommand;
import spring.phlodx.recipeapp.commands.RecipeCommand;
import spring.phlodx.recipeapp.converters.IngredientToIngredientCommand;
import spring.phlodx.recipeapp.converters.RecipeCommandToRecipe;
import spring.phlodx.recipeapp.converters.RecipeToRecipeCommand;
import spring.phlodx.recipeapp.domain.Ingredient;
import spring.phlodx.recipeapp.domain.Recipe;
import spring.phlodx.recipeapp.repositories.RecipeRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientConverter;

    public IngredientServiceImpl(RecipeRepository recipeRepository, IngredientToIngredientCommand ingredientConverter) {
        this.recipeRepository = recipeRepository;
        this.ingredientConverter = ingredientConverter;
    }


    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {

        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);

        if (!recipeOptional.isPresent()){
            //todo impl error handling
            log.error("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredientConverter::convert).findFirst();

        if(!ingredientCommandOptional.isPresent()){
            //todo impl error handling
            log.error("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
