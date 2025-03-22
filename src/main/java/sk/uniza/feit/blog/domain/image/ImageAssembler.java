package sk.uniza.feit.blog.domain.image;

import java.util.List;

public class ImageAssembler {

    private ImageAssembler() {
    }

    public static ImageResponse toDto(String baseUrl, Image image) {
        return new ImageResponse(image.getId(), image.getName(), baseUrl + image.getFilePath());
    }

    public static List<ImageResponse> toDto(String baseUrl, List<Image> images) {
        return images.stream()
                .map(image -> toDto(baseUrl, image))
                .toList();
    }

}
