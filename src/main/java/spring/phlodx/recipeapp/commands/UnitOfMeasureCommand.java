package spring.phlodx.recipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UnitOfMeasureCommand {
    private Long id;
    private String uom;
}
