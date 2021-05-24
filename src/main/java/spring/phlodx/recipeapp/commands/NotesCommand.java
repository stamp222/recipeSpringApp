package spring.phlodx.recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.phlodx.recipeapp.domain.Recipe;

@Setter
@Getter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private RecipeCommand recipe;
    private String recipeNotes;
}
