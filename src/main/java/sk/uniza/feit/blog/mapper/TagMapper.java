package sk.uniza.feit.blog.mapper;

import org.mapstruct.*;
import sk.uniza.feit.blog.domain.Tag;
import sk.uniza.feit.site.rest.dto.TagDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    @Mapping(target = "posts", ignore = true)
    Tag toEntity(TagDto tagDto);

    @Mapping(target = "posts", ignore = true)
    List<Tag> toEntity(List<TagDto> tagDtos);

    TagDto toDto(Tag tag);

    List<TagDto> toDto(List<Tag> tags);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "posts", ignore = true)
    Tag partialUpdate(TagDto tagDto, @MappingTarget Tag tag);
}
