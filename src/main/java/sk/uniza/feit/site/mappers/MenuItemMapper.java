package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.MenuItem;
import sk.uniza.feit.site.rest.dto.MenuItemDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MenuItemMapper {
    MenuItem toEntity(MenuItemDto menuItemDto);

    MenuItemDto toDto(MenuItem menuItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MenuItem partialUpdate(MenuItemDto menuItemDto,
                           @MappingTarget MenuItem menuItem);
}
