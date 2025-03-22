package sk.uniza.feit.blog.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import sk.uniza.feit.blog.domain.PageList;
import sk.uniza.feit.blog.domain.Post;
import sk.uniza.feit.blog.domain.repository.PostRepository;
import sk.uniza.feit.site.rest.dto.PostRequestDto;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final TagService tagService;

    public PostService(PostRepository postRepository, TagService tagService) {
        this.postRepository = postRepository;
        this.tagService = tagService;
    }

    // create pageable method, on input is page number and size
    public PageList<Post> findAll(Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue()).withSort(Sort.by("createdAt").descending());
        Page<Post> posts = postRepository.findAll(pageable);
        return new PageList<>(posts.getContent(), posts.getTotalElements(), posts.hasNext());
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> findByTags(List<String> tags) {
        return postRepository.findByTags(tags);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, PostRequestDto postRequestDto) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));

        // Update the post fields
        existingPost.setTitle(postRequestDto.getTitle());
        existingPost.setContent(postRequestDto.getContent());
        existingPost.setTags(tagService.create(postRequestDto.getTags()));
        return postRepository.save(existingPost);
    }
}
