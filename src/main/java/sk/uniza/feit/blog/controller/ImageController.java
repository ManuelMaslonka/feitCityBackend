package sk.uniza.feit.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sk.uniza.feit.blog.domain.PageList;
import sk.uniza.feit.blog.domain.image.ImageResponse;
import sk.uniza.feit.blog.domain.image.ImageService;
import sk.uniza.feit.blog.mapper.PageListMapper;
import sk.uniza.feit.site.rest.api.ImageRestApi;
import sk.uniza.feit.site.rest.dto.GetAllImagesRequestDto;
import sk.uniza.feit.site.rest.dto.GetImage200ResponseDto;
import sk.uniza.feit.site.rest.dto.PageListPostDto;
import sk.uniza.feit.site.rest.dto.UploadImage200ResponseDto;

import java.io.IOException;

@RestController
public class ImageController implements ImageRestApi {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @Override
    public ResponseEntity<Void> deleteImage(Long id) {
        this.imageService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<PageListPostDto> getAllImages(GetAllImagesRequestDto getAllImagesRequestDto) {
        PageList<ImageResponse> pageableImages = this.imageService.getPageableImages(getAllImagesRequestDto.getPage(), getAllImagesRequestDto.getSize());
        return new ResponseEntity<>(PageListMapper.getPageListPostDto(pageableImages), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GetImage200ResponseDto> getImage(Long id) {
        return ResponseEntity.ok(new GetImage200ResponseDto().url(this.imageService.getImageUrl(id)));
    }


    @Override
    public ResponseEntity<UploadImage200ResponseDto> uploadImage(MultipartFile file) {
        try {
            return ResponseEntity.ok(new UploadImage200ResponseDto().url(this.imageService.uploadImage(file)));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
