package sk.uniza.feit.blog.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sk.uniza.feit.blog.domain.AlreadyExistEntity;
import sk.uniza.feit.blog.domain.Tag;
import sk.uniza.feit.blog.domain.repository.TagRepository;
import sk.uniza.feit.blog.mapper.TagMapper;
import sk.uniza.feit.site.rest.dto.TagDto;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public TagDto create(Tag tag) {
        boolean exists = tagRepository.existsByName(tag.getName());

        if (exists) {
            throw new AlreadyExistEntity("Tag with name " + tag.getName() + " already exists");
        }

        Tag save = tagRepository.save(tag);

        return tagMapper.toDto(save);
    }

    public Tag createPure(String tagName) {
        if (tagRepository.existsByName(tagName)) {
            throw new AlreadyExistEntity("Tag with name " + tagName + " already exists");
        }

        Tag tag = new Tag(tagName);
        return tagRepository.save(tag);
    }

    public List<Tag> create(List<String> tags) {
        for (String tagName : tags) {
            // Find existing tag or create a new one
            if (!tagRepository.existsByName(tagName)) {
                tagRepository.save(new Tag(tagName));
            }
        }

        return tagRepository.findAllByNameIn(tags);
    }

    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tag -> {
                    TagDto tagDto = new TagDto(tag.getName());
                    tagDto.setId(tag.getId());
                    return tagDto;
                })
                .toList();
    }

    public TagDto getById(Long id) {
        return tagRepository.findById(id).map(tag -> new TagDto(tag.getName())).orElseThrow(
                () -> new EntityNotFoundException("Tag with id " + id + " not found")
        );
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }

    public void deleteAll(List<Tag> tags) {
        if (tags == null || tags.isEmpty()) {
            return;
        }
        tagRepository.deleteAll(tags);
    }
}
