package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository <UnitOfMeasure, Long> {
}
