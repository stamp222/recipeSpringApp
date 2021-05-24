package spring.phlodx.recipeapp.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.phlodx.recipeapp.commands.CategoryCommand;
import spring.phlodx.recipeapp.domain.Category;

import static org.junit.jupiter.api.Assertions.*;

class CategoryToCategoryCommandTest {

    public static final Long ID_VALUE = 1L;
    public static final String DESCRIPTION = "description";

    CategoryToCategoryCommand converter;

    @BeforeEach
    void setUp() {
        converter = new CategoryToCategoryCommand();
    }

    @Test
    void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void testEmptyObject() {
        assertNotNull(converter.convert(new Category()));
    }

    @Test
    void convert() {
        Category category = new Category();
        category.setId(ID_VALUE);
        category.setCategory(DESCRIPTION);

        CategoryCommand categoryCommand = converter.convert(category);

        assertEquals(categoryCommand.getId(), ID_VALUE);
        assertEquals(categoryCommand.getCategory(), DESCRIPTION);

    }
}