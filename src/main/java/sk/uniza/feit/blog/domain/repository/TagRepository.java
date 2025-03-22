package sk.uniza.feit.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.blog.domain.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    List<Tag> findAllByNameIn(List<String> tags);

    boolean existsByName(String name);
}
