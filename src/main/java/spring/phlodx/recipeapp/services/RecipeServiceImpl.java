package spring.phlodx.recipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.phlodx.recipeapp.commands.RecipeCommand;
import spring.phlodx.recipeapp.converters.RecipeCommandToRecipe;
import spring.phlodx.recipeapp.converters.RecipeToRecipeCommand;
import spring.phlodx.recipeapp.domain.Recipe;
import spring.phlodx.recipeapp.exceptions.NotFoundException;
import spring.phlodx.recipeapp.repositories.RecipeRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommandConverter;
    private final RecipeCommandToRecipe recipeCommandToRecipeConverter;



    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommandConverter, RecipeCommandToRecipe recipeCommandToRecipeConverter) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommandConverter = recipeToRecipeCommandConverter;
        this.recipeCommandToRecipeConverter = recipeCommandToRecipeConverter;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Im in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent())
//            throw new RuntimeException("Recipe Not Found");
            throw new NotFoundException("Recipe Not Found");
        else
            return recipeOptional.get();
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand recipe) {
        Recipe savedRecipe = recipeRepository.save(recipeCommandToRecipeConverter.convert(recipe));
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommandConverter.convert(savedRecipe);
    }

    @Override
    @Transactional
    public RecipeCommand findCommandById(Long id) {
        return recipeToRecipeCommandConverter.convert(findById(id));
    }

    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
