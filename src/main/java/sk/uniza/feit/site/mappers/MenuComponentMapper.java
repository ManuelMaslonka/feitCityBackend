package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.MenuComponent;
import sk.uniza.feit.site.rest.dto.MenuComponentDto;

@Mapper(
        uses = {MenuItemMapper.class, DropDownMenuItemMapper.class, ButtonMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)public interface MenuComponentMapper {

    @Mapping(source = "dropdownMenuItems", target = "dropdownMenuItems")
    MenuComponent toEntity(MenuComponentDto menuComponentDto);

    @Mapping(source = "dropdownMenuItems", target = "dropdownMenuItems")
    MenuComponentDto toDto(MenuComponent menuComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)MenuComponent partialUpdate(MenuComponentDto menuComponentDto,
                                                                                                                        @MappingTarget MenuComponent menuComponent);
}
