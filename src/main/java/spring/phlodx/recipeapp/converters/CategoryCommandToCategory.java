package spring.phlodx.recipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.phlodx.recipeapp.commands.CategoryCommand;
import spring.phlodx.recipeapp.commands.UnitOfMeasureCommand;
import spring.phlodx.recipeapp.domain.Category;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {



    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if (source == null)
            return null;
        Category category = new Category();
        category.setCategory(source.getCategory());
        category.setId(source.getId());
        return category;
    }
}
