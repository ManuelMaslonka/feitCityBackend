package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.WhyFeitComponent;
import sk.uniza.feit.site.rest.dto.WhyFeitComponentDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface WhyFeitComponentMapper {
    WhyFeitComponent toEntity(WhyFeitComponentDto whyFeitComponentDto);

    WhyFeitComponentDto toDto(WhyFeitComponent whyFeitComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    WhyFeitComponent partialUpdate(
            WhyFeitComponentDto whyFeitComponentDto, @MappingTarget WhyFeitComponent whyFeitComponent);
}
