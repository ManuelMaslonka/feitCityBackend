package sk.uniza.feit.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.blog.domain.Tag;
import sk.uniza.feit.blog.domain.service.TagService;
import sk.uniza.feit.site.rest.api.TagsRestApi;
import sk.uniza.feit.site.rest.dto.TagDto;
import sk.uniza.feit.site.rest.dto.TagRequestDto;

import java.util.Collections;
import java.util.List;

@RestController
public class TagsController implements TagsRestApi {

    private final TagService tagService;

    public TagsController(TagService tagService) {
        this.tagService = tagService;
    }

    @Override
    public ResponseEntity<TagDto> createTag(TagRequestDto tagRequestDto) {
        return ResponseEntity.ok(tagService.create(new Tag(tagRequestDto.getName(), Collections.emptyList())));
    }

    @Override
    public ResponseEntity<Void> deleteTagById(Long id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<TagDto>> getAllTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @Override
    public ResponseEntity<TagDto> getTagById(Long id) {
        return ResponseEntity.ok(tagService.getById(id));
    }
}
