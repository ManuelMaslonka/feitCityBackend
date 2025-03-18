package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "slider_item")
public class SliderItem  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "info_description")
    private String infoDescription;

    @Column(name = "label")
    private String label;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(name = "icons_style")
    private String iconsStyle;

    public SliderItem() {}

    public SliderItem(Long id, String title, String description, String infoDescription, String label, String imageUrl, String videoUrl, String iconsStyle) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.infoDescription = infoDescription;
        this.label = label;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.iconsStyle = iconsStyle;
    }

    public String getIconsStyle() {
        return iconsStyle;
    }

    public void setIconsStyle(String iconsStyle) {
        this.iconsStyle = iconsStyle;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfoDescription() {
        return infoDescription;
    }

    public void setInfoDescription(String infoDescription) {
        this.infoDescription = infoDescription;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
