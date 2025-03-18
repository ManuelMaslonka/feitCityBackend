package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.SliderComponent;
import sk.uniza.feit.site.rest.dto.SliderComponentDto;

@Mapper(uses = {SliderItemMapper.class},unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SliderComponentMapper {
    SliderComponent toEntity(SliderComponentDto sliderComponentDto);

    SliderComponentDto toDto(SliderComponent sliderComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SliderComponent partialUpdate(SliderComponentDto sliderComponentDto,
                                  @MappingTarget SliderComponent sliderComponent);
}
