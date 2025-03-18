package sk.uniza.feit.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.security.domain.dto.SignInResponse;
import sk.uniza.feit.site.rest.dto.SignInResponseDto;

@Mapper(
        uses = {AccessTokenMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = MappingConstants.ComponentModel.SPRING
)
public interface SignInResponseMapper {
    SignInResponse toEntity(SignInResponseDto signInResponseDto);

    SignInResponseDto toDto(SignInResponse signInResponse);

}
