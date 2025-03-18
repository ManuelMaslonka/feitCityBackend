package sk.uniza.feit.blog.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.uniza.feit.blog.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
