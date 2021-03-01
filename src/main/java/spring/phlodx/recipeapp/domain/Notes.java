package spring.phlodx.recipeapp.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // w tym wypadku Recipe jest właścicielem Notes. Niechcemy gdy usuwa się Notes też usuwało Recipe. dlatego tu nie dodajemy kaskady.
    @OneToOne
    private Recipe recipe;
    @Lob
    private String recipeNotes;

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
