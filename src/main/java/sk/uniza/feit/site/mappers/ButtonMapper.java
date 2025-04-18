package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.Button;
import sk.uniza.feit.site.rest.dto.ButtonDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ButtonMapper {
    Button toEntity(ButtonDto buttonDto);

    ButtonDto toDto(Button button);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Button partialUpdate(ButtonDto buttonDto,
                         @MappingTarget Button button);
}
