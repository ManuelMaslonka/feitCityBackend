package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.VideoItem;
import sk.uniza.feit.site.rest.dto.VideoItemDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoItemMapper {
    VideoItem toEntity(VideoItemDto videoItemDto);

    VideoItemDto toDto(VideoItem videoItem);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    VideoItem partialUpdate(VideoItemDto videoItemDto,
                            @MappingTarget VideoItem videoItem);
}
