package sk.uniza.feit.site.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import sk.uniza.feit.site.rest.dto.SettingsDto;
import sk.uniza.feit.user.domain.Settings;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface SettingsMapper {

    @Mapping(target = "id", ignore = true)
    Settings toEntity(SettingsDto settingsDto);

    SettingsDto toDto(Settings settings);

}
