package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.LogoComponent;
import sk.uniza.feit.site.rest.dto.LogoComponentDto;

@Mapper(uses = {LogoItemMapper.class}, unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LogoComponentMapper {
    LogoComponent toEntity(LogoComponentDto logoComponentDto);

    LogoComponentDto toDto(LogoComponent logoComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    LogoComponent partialUpdate(LogoComponentDto logoComponentDto,
                                @MappingTarget LogoComponent logoComponent);
}
