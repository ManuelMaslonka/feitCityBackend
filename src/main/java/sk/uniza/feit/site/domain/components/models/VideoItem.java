package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

@Table(name = "video_item")
@Entity(name = "VideoItem")
public class VideoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "image_url")
    private String imageUrl;

    public VideoItem(Long id, String title, String videoUrl, String imageUrl) {
        this.id = id;
        this.title = title;
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
    }

    public VideoItem() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
