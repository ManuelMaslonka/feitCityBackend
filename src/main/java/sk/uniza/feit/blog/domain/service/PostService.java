package sk.uniza.feit.blog.domain.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.uniza.feit.blog.domain.PageList;
import sk.uniza.feit.blog.domain.Post;
import sk.uniza.feit.blog.domain.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // create pageable method, on input is page number and size
    public PageList<Post> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size).withSort(Sort.by("createdAt").descending());
        List<Post> posts = postRepository.findAll(pageable).getContent();
        return new PageList<>(posts, postRepository.count(), null);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

}
