package spring.phlodx.recipeapp.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.phlodx.recipeapp.commands.UnitOfMeasureCommand;
import spring.phlodx.recipeapp.domain.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {


    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null)
            return null;
        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(source.getId());
        uomc.setUom(source.getUom());
        return uomc;
    }
}
