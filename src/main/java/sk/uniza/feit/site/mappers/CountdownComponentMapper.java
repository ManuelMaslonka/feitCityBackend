package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.CountdownComponent;
import sk.uniza.feit.site.rest.dto.CountdownComponentDto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountdownComponentMapper {
    CountdownComponent toEntity(CountdownComponentDto countdownComponentDto);

    CountdownComponentDto toDto(CountdownComponent countdownComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CountdownComponent partialUpdate(
            CountdownComponentDto countdownComponentDto, @MappingTarget CountdownComponent countdownComponent);
}
