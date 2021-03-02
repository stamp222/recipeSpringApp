package spring.phlodx.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.phlodx.recipeapp.domain.Category;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;
import spring.phlodx.recipeapp.repositories.CategoryRepository;
import spring.phlodx.recipeapp.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "index"})
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByCategory("Mexican");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Tablespoon");

        System.out.println("Category Id is : " + categoryOptional.get().getId());
        System.out.println("Uom Id is : " + unitOfMeasureOptional.get().getId());

        return "index";
    }

}
