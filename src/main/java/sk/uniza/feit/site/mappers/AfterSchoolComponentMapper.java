package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.AfterSchoolComponent;
import sk.uniza.feit.site.rest.dto.AfterSchoolComponentDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AfterSchoolComponentMapper {
    AfterSchoolComponent toEntity(AfterSchoolComponentDto afterSchoolComponentDto);

    AfterSchoolComponentDto toDto(AfterSchoolComponent afterSchoolComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AfterSchoolComponent partialUpdate(
            AfterSchoolComponentDto afterSchoolComponentDto, @MappingTarget AfterSchoolComponent afterSchoolComponent);
}
