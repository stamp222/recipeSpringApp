package spring.phlodx.recipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository <UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByUom(String uom);
}
