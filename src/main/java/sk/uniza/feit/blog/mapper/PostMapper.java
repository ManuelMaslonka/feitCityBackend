package sk.uniza.feit.blog.mapper;

import org.mapstruct.*;
import sk.uniza.feit.blog.domain.Post;
import sk.uniza.feit.site.rest.dto.PostDto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper(uses = {TagMapper.class}, unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    Post toEntity(PostDto postDto);

    PostDto toDto(Post post);

    List<PostDto> toDto(List<Post> posts);

    List<Post> toEntity(List<PostDto> postDtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(PostDto postDto, @MappingTarget Post post);

    // Convert OffsetDateTime to LocalDateTime
    default LocalDateTime map(OffsetDateTime value) {
        return value != null ? value.toLocalDateTime() : null;
    }

    // Convert LocalDateTime to OffsetDateTime
    default OffsetDateTime map(LocalDateTime value) {
        return value != null ? OffsetDateTime.of(value, ZoneOffset.UTC) : null;
    }
}
