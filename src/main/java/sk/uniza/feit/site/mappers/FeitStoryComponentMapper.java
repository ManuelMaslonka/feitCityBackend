package sk.uniza.feit.site.mappers;

import org.mapstruct.*;
import sk.uniza.feit.site.domain.components.models.FeitStoryComponent;
import sk.uniza.feit.site.rest.dto.FeatureBoxComponentDto;
import sk.uniza.feit.site.rest.dto.FeitStoryComponentDto;

@Mapper(uses = {
        VideoItemMapper.class,
}, unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface FeitStoryComponentMapper {
    @Mapping(source = "videoItemList", target = "videoItemList")
    FeitStoryComponent toEntity(FeitStoryComponentDto feitStoryComponentDto);

    @Mapping(source = "videoItemList", target = "videoItemList")
    FeitStoryComponentDto toDto(FeitStoryComponent feitStoryComponent);

}
