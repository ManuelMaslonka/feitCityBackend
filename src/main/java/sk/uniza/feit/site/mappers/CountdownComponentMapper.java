package sk.uniza.feit.site.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.site.domain.components.models.CountdownComponent;
import sk.uniza.feit.site.rest.dto.CountdownComponentDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CountdownComponentMapper {
    CountdownComponent toEntity(CountdownComponentDto countdownComponentDto);

    CountdownComponentDto toDto(CountdownComponent countdownComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CountdownComponent partialUpdate(
            CountdownComponentDto countdownComponentDto, @MappingTarget CountdownComponent countdownComponent);

    default CountdownComponent mapToEntity(CountdownComponentDto countdownComponentDto) {
        if (countdownComponentDto == null) {
            return null;
        }

        LocalDateTime endDate = parseToLocalDateTime(countdownComponentDto.getEndDate());

        CountdownComponent countdownComponent = new CountdownComponent();
        countdownComponent.setVisible(countdownComponentDto.getVisible());
        countdownComponent.setEndDate(endDate);
        countdownComponent.setApplicationText(countdownComponentDto.getApplicationText());
        return countdownComponent;

    }


    default LocalDateTime parseToLocalDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }
}
