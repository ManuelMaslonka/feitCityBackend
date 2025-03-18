package sk.uniza.feit.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.security.domain.dto.SignUpRequest;
import sk.uniza.feit.site.rest.dto.SignUpRequestDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SignUpRequestMapper {

    SignUpRequest toEntity(SignUpRequestDto signUpRequestDto);

    SignUpRequestDto toDto(SignUpRequest signUpRequest);

    default Optional<String> map(LocalDate value) {
        return Optional.ofNullable(value).map(date -> date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    default LocalDate map(Optional<String> value) {
        return value.map(date -> LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))).orElse(null);
    }

}
