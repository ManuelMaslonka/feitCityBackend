package sk.uniza.feit.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.blog.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
