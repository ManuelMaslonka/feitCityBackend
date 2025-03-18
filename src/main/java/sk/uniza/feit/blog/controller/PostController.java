package sk.uniza.feit.blog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.blog.domain.repository.PostRepository;
import sk.uniza.feit.site.rest.api.BlogRestApi;
import sk.uniza.feit.site.rest.dto.PageListPostDto;
import sk.uniza.feit.site.rest.dto.PostDto;
import sk.uniza.feit.site.rest.dto.PostRequestDto;

@RestController
public class PostController implements BlogRestApi {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public ResponseEntity<PostDto> createPost(PostRequestDto postRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PageListPostDto> getAllPosts(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<PostDto> getPostById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<PostDto> updatePost(Long id, PostRequestDto postRequestDto) {
        return null;
    }
}
