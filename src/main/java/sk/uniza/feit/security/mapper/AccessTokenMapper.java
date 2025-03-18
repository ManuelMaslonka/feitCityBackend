package sk.uniza.feit.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.site.rest.dto.AccessTokenDto;
import sk.uniza.feit.user.token.AccessToken;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccessTokenMapper {

    @Mapping(target = "id", ignore = true)
    AccessToken toEntity(AccessTokenDto accessTokenDto);

    AccessTokenDto toDto(AccessToken accessToken);

    default LocalDateTime map(OffsetDateTime value) {
        if (value != null) {
            return value.toLocalDateTime();
        }
        return null;
    }

    default OffsetDateTime map(LocalDateTime value) {
        if (value != null) {
            return value.atOffset(ZoneOffset.UTC);
        }
        return null;
    }
}
