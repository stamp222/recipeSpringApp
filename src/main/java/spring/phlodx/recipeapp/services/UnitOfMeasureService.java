package spring.phlodx.recipeapp.services;

import spring.phlodx.recipeapp.commands.UnitOfMeasureCommand;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

import java.util.Set;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
