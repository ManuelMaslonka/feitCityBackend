package sk.uniza.feit.blog.domain.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import sk.uniza.feit.blog.domain.AlreadyExistEntity;
import sk.uniza.feit.blog.domain.Tag;
import sk.uniza.feit.blog.domain.repository.TagRepository;
import sk.uniza.feit.site.rest.dto.TagDto;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagDto create(Tag tag) {
        boolean exists = tagRepository.existsByName(tag.getName());

        if (exists) {
            throw new AlreadyExistEntity("Tag with name " + tag.getName() + " already exists");
        }

        return new TagDto(tagRepository.save(tag).getName());
    }

    public List<Tag> create(List<String> tags) {
        for (String tagName : tags) {
            // Find existing tag or create a new one
            if (!tagRepository.existsByName(tagName)) {
                tagRepository.save(new Tag(null, tagName));
            }
        }

        return tagRepository.findAllByNameIn(tags);
    }

    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(tag -> new TagDto(tag.getName()))
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
}
