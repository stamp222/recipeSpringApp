package spring.phlodx.recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.phlodx.recipeapp.domain.Category;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;
import spring.phlodx.recipeapp.repositories.CategoryRepository;
import spring.phlodx.recipeapp.repositories.UnitOfMeasureRepository;
import spring.phlodx.recipeapp.services.RecipeService;

import java.util.Optional;

@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage(Model model) {

        log.debug("GetIndexPage started");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }

}
