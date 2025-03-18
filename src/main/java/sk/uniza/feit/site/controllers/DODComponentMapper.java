package sk.uniza.feit.site.controllers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.DODComponent;
import sk.uniza.feit.site.rest.dto.DODComponentDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DODComponentMapper {
    DODComponent toEntity(DODComponentDto DODComponentDto);

    DODComponentDto toDto(DODComponent DODComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DODComponent partialUpdate(DODComponentDto DODComponentDto,
                               @MappingTarget DODComponent DODComponent);
}
