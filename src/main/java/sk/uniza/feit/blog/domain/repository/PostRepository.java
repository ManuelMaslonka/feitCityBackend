package sk.uniza.feit.blog.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sk.uniza.feit.blog.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.name IN :tagNames")
    List<Post> findByTags(@Param("tagNames") List<String> tagNames);

    @Query("SELECT DISTINCT p FROM Post p JOIN p.tags t WHERE t.name IN :tagNames")
    Page<Post> findAllByTags(@Param("tagNames") List<String> tagNames, Pageable pageable);

    Page<Post> findAllByAuthor(String author, Pageable pageable);
}
