package sk.uniza.feit.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sk.uniza.feit.blog.domain.Post;
import sk.uniza.feit.blog.domain.Tag;
import sk.uniza.feit.blog.domain.image.ImageService;
import sk.uniza.feit.blog.domain.service.PostService;
import sk.uniza.feit.blog.domain.service.TagService;
import sk.uniza.feit.blog.mapper.PageListMapper;
import sk.uniza.feit.blog.mapper.PostMapper;
import sk.uniza.feit.security.domain.service.CurrentUserDetailService;
import sk.uniza.feit.site.rest.api.BlogRestApi;
import sk.uniza.feit.site.rest.dto.AddTagsToPost200ResponseDto;
import sk.uniza.feit.site.rest.dto.AddTagsToPostRequestDto;
import sk.uniza.feit.site.rest.dto.PageListPostDto;
import sk.uniza.feit.site.rest.dto.PostDto;
import sk.uniza.feit.site.rest.dto.PostRequestDto;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PostController implements BlogRestApi {


    private final PostService postService;
    private final CurrentUserDetailService currentUserDetailService;
    private final PostMapper postMapper;
    private final TagService tagService;
    private final ImageService imageService;

    public PostController(PostService postService, CurrentUserDetailService currentUserDetailService, PostMapper postMapper, TagService tagService,
                          ImageService imageService) {
        this.postService = postService;
        this.currentUserDetailService = currentUserDetailService;
        this.postMapper = postMapper;
        this.tagService = tagService;
        this.imageService = imageService;
    }

    @Override
    public ResponseEntity<AddTagsToPost200ResponseDto> addTagsToPost(AddTagsToPostRequestDto addTagsToPostRequestDto) {
        Post post = postService.findById(addTagsToPostRequestDto.getPostId());
        List<Tag> tags = tagService.create(addTagsToPostRequestDto.getTagNames());
        post.setTags(tags);
        postService.save(post);
        return ResponseEntity.ok(new AddTagsToPost200ResponseDto().message("Tags added successfully"));
    }

    @Override
    public ResponseEntity<PostDto> createPost(PostRequestDto postRequestDto, MultipartFile mainImage) {
        try {
            Post post = new Post();
            post.setTitle(postRequestDto.getTitle());
            post.setContent(postRequestDto.getContent());
            post.setAuthor(currentUserDetailService.getFullCurrentUser().getName());
            post.setCreatedAt(LocalDateTime.now());

            if (postRequestDto.getTags() != null) {
                List<Tag> tags = tagService.create(postRequestDto.getTags());
                post.setTags(tags);
            }


            if (mainImage != null) {
                post.setMainImageUrl(imageService.uploadImage(mainImage));
            }

            Post savedPost = postService.save(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(postMapper.toDto(savedPost));
        } catch (IOException e) {
            throw new RuntimeException("Error processing image data", e);
        } catch (Exception e) {
            throw new RuntimeException("Error creating post", e);
        }
    }

    @Override
    public ResponseEntity<Void> deletePost(Long id) {
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PageListPostDto> getAllPosts(Long page, Long size) {
        PageListPostDto pageListPostDto = PageListMapper.getPageListPostDto(postService.findAll(page, size));
        return ResponseEntity.ok(pageListPostDto);
    }

    @Override
    public ResponseEntity<PostDto> getPostById(Long id) {
        return ResponseEntity.ok(postMapper.toDto(postService.findById(id)));
    }

    @Override
    public ResponseEntity<PageListPostDto> getPostsByTags(List<String> tagNames, Long page, Long size) {
        PageListPostDto pageListPostDto = PageListMapper.getPageListPostDto(postService.findAllByTags(tagNames, page, size));
        return ResponseEntity.ok(pageListPostDto);
    }

    @Override
    public ResponseEntity<PostDto> updatePost(Long id, PostRequestDto postRequestDto) {
        return ResponseEntity.ok(postMapper.toDto(postService.updatePost(id, postRequestDto)));
    }

}
