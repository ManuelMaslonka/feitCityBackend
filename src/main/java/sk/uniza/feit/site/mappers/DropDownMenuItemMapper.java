package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.DropDownMenuItem;
import sk.uniza.feit.site.rest.dto.DropDownMenuItemDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DropDownMenuItemMapper {
    DropDownMenuItem toEntity(DropDownMenuItemDto dropDownMenuItemDto);

    DropDownMenuItemDto toDto(DropDownMenuItem dropDownMenuItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DropDownMenuItem partialUpdate(
            DropDownMenuItemDto dropDownMenuItemDto, @MappingTarget DropDownMenuItem dropDownMenuItem);
}
