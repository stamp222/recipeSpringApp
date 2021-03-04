package spring.phlodx.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.phlodx.recipeapp.domain.Category;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;
import spring.phlodx.recipeapp.repositories.CategoryRepository;
import spring.phlodx.recipeapp.repositories.UnitOfMeasureRepository;
import spring.phlodx.recipeapp.services.RecipeService;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
