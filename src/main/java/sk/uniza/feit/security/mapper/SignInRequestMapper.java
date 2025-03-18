package sk.uniza.feit.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.security.domain.dto.SignInRequest;
import sk.uniza.feit.site.rest.dto.SignInRequestDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SignInRequestMapper {
    SignInRequest toEntity(SignInRequestDto signInRequestDto);

    SignInRequestDto toDto(SignInRequest signInRequest);

}
