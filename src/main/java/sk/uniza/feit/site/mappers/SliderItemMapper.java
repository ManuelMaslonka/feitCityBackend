package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.SliderItem;
import sk.uniza.feit.site.rest.dto.SliderItemDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SliderItemMapper {
    SliderItem toEntity(SliderItemDto sliderItemDto);

    SliderItemDto toDto(SliderItem sliderItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SliderItem partialUpdate(SliderItemDto sliderItemDto,
                             @MappingTarget SliderItem sliderItem);
}
