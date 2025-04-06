package sk.uniza.feit.blog.domain.image;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sk.uniza.feit.blog.domain.PageList;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.UUID;

@Service
public class ImageService {

    private static final String IMAGE_PATH_REL = "src/main/resources/static/images";

    private static final float IMAGE_COMPRESSION_QUALITY = 0.7f;

    @Value("${application.image.base-url}")
    private String imageBaseUrl;

    @Value("${application.url.base-url}")
    private String baseUrl;

    @Value("${application.url.api-url}")
    private String apiUrl;

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public String uploadImageForComponent(MultipartFile file) throws IOException {
        Path directory =createDirectory("feitImages");
        String originalFilename = file.getOriginalFilename();
        String extension = getFileExtension(originalFilename);

        byte[] compressedImage = compressImage(file, extension);

        Path targatPath = directory.resolve(originalFilename);
        Files.write(targatPath, compressedImage);
        String relativePath = String.format("%s/%s", "feitImages", originalFilename);
        Image image = new Image(
                null,
                file.getOriginalFilename(),
                file.getContentType(),
                relativePath
        );
        imageRepository.save(image);
        return relativePath;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        Path directory = createDirectory(getYearMothFormatted());
        String originalFilename = file.getOriginalFilename();
        String extension = getFileExtension(originalFilename);
        String filename = UUID.randomUUID().toString() + "." + extension;

        byte[] compressedImage = compressImage(file, extension);

        Path targatPath = directory.resolve(filename);
        Files.write(targatPath, compressedImage);

        String relativePath = String.format("%s/%s/%s", getYearMothFormatted().year(), getYearMothFormatted().month(), filename);

        Image image = new Image(
                null,
                file.getOriginalFilename(),
                file.getContentType(),
                relativePath
        );

        imageRepository.save(image);
        return baseUrl + apiUrl + imageBaseUrl + relativePath;
    }

    private byte[] compressImage(MultipartFile file, String extension) throws IOException {
        if (!isCompressibleImageFormat(extension)) {
            return file.getBytes();
        }

        BufferedImage inputImage = ImageIO.read(file.getInputStream());
        if (inputImage == null) {
            return file.getBytes();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName(extension);
        if (!writers.hasNext()) {
            return file.getBytes();
        }

        ImageWriter writer = writers.next();
        ImageOutputStream imageOutputStream = ImageIO.createImageOutputStream(outputStream);
        writer.setOutput(imageOutputStream);

        ImageWriteParam param = writer.getDefaultWriteParam();
        if (param.canWriteCompressed()) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(IMAGE_COMPRESSION_QUALITY);
        }

        writer.write(null, new IIOImage(inputImage, null, null), param);

        writer.dispose();
        imageOutputStream.close();

        return outputStream.toByteArray();
    }

    private boolean isCompressibleImageFormat(String extension) {
        return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png");
    }

    private static Path createDirectory(YearMothFormatted result) throws IOException {
        Path targetDirectory = Paths.get(IMAGE_PATH_REL, result.year(), result.month());
        Files.createDirectories(targetDirectory);
        return targetDirectory;
    }

    private static Path createDirectory(String name) throws IOException {
        Path targetDirectory = Paths.get(IMAGE_PATH_REL, name);
        Files.createDirectories(targetDirectory);
        return targetDirectory;
    }

    private static YearMothFormatted getYearMothFormatted() {
        LocalDate now = LocalDate.now();
        String year = String.valueOf(now.getYear());
        String month = String.format("%02d", now.getMonthValue());
        return new YearMothFormatted(year, month);
    }

    private String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex == -1) ? "" : filename.substring(dotIndex + 1);
    }

    @Transactional
    public void delete(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Image with id " + id + " not found"));

        Path path = Paths.get(IMAGE_PATH_REL, image.getFilePath());
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete image file: " + path, e);
        }

        imageRepository.delete(image);
    }

    public PageList<ImageResponse> getPageableImages(Long page, Long size) {
        int pageInt = page.intValue();
        int sizeInt = size.intValue();
        Page<Image> content = this.imageRepository.findAll(PageRequest.of(pageInt, sizeInt));
        boolean summaryRow = content.hasNext();
        return new PageList<>(ImageAssembler.toDto(getBaseUrl(), content.getContent()), content.getTotalElements(), summaryRow);
    }

    private String getBaseUrl() {
        return baseUrl + apiUrl + imageBaseUrl;
    }

    public String getImageUrl(Long id) {
        return getBaseUrl() + this.imageRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Image with id " + id + " not found")
        ).getFilePath();
    }
}
