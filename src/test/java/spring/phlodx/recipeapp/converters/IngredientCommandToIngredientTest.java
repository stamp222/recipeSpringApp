package spring.phlodx.recipeapp.converters;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spring.phlodx.recipeapp.commands.IngredientCommand;
import spring.phlodx.recipeapp.commands.UnitOfMeasureCommand;
import spring.phlodx.recipeapp.domain.Ingredient;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class IngredientCommandToIngredientTest {

    IngredientCommandToIngredient ingredientCommandToIngredientConverter;
    private static final Long ID_VALUE = 1L;
    private static final BigDecimal AMOUNT = new BigDecimal("10");
    private static final String DESCRIPTION = "description";
    private static final Long UOM_ID = 1L;


    @BeforeEach
    void setUp() {
        ingredientCommandToIngredientConverter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    @Test
    void testNullObject() {
        ingredientCommandToIngredientConverter.convert(null);
    }

    @Test
    void testEmptyObject() {
        ingredientCommandToIngredientConverter.convert(new IngredientCommand());
    }

    @Test
    void convert() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
        unitOfMeasureCommand.setId(UOM_ID);
        ingredientCommand.setUom(unitOfMeasureCommand);
        ingredientCommand.setAmount(AMOUNT);

        Ingredient ingredient = ingredientCommandToIngredientConverter.convert(ingredientCommand);


        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ingredient.getId(), ID_VALUE);
        assertEquals(ingredient.getAmount(), AMOUNT);
        assertEquals(ingredient.getDescription(), DESCRIPTION);
        assertEquals(ingredient.getUom().getId(), UOM_ID);
    }

    @Test
    void convertWithNullUOM() {
        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ID_VALUE);
        ingredientCommand.setDescription(DESCRIPTION);
        ingredientCommand.setAmount(AMOUNT);

        Ingredient ingredient = ingredientCommandToIngredientConverter.convert(ingredientCommand);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ingredient.getId(), ID_VALUE);
        assertEquals(ingredient.getAmount(), AMOUNT);
        assertEquals(ingredient.getDescription(), DESCRIPTION);
    }

}