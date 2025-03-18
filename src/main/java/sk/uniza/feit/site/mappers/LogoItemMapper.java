package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.LogoItem;
import sk.uniza.feit.site.rest.dto.LogoItemDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogoItemMapper {
    LogoItem toEntity(LogoItemDto logoItemDto);

    LogoItemDto toDto(LogoItem logoItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LogoItem partialUpdate(LogoItemDto logoItemDto,
                           @MappingTarget LogoItem logoItem);
}
