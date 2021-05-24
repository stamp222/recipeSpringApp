package spring.phlodx.recipeapp.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import spring.phlodx.recipeapp.commands.RecipeCommand;
import spring.phlodx.recipeapp.converters.RecipeCommandToRecipe;
import spring.phlodx.recipeapp.converters.RecipeToRecipeCommand;
import spring.phlodx.recipeapp.domain.Recipe;
import spring.phlodx.recipeapp.repositories.RecipeRepository;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RecipeServiceIT {
    public static final String NEW_DESCRIPTION = "New description";

    @Autowired
    RecipeService recipeService;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveOfDescription() {

        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand saveRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        assertEquals(NEW_DESCRIPTION, saveRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(), saveRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(), saveRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(), saveRecipeCommand.getIngredients().size());

    }

}
