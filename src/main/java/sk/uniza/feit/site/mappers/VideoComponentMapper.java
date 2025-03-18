package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.VideoComponent;
import sk.uniza.feit.site.rest.dto.VideoComponentDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoComponentMapper {
    VideoComponent toEntity(VideoComponentDto videoComponentDto);

    VideoComponentDto toDto(VideoComponent videoComponent);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    VideoComponent partialUpdate(VideoComponentDto videoComponentDto,
                                 @MappingTarget VideoComponent videoComponent);
}
