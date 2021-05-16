package spring.phlodx.recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;

        category.setId(4L);

        assertEquals(idValue, category.getId());

    }

    @org.junit.Test
    public void getCategory() {
    }

    @org.junit.Test
    public void getRecipes() {
    }
}