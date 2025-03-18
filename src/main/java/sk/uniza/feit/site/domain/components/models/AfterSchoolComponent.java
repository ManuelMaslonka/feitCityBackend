package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "after_school_components")
@Entity(name = "AfterSchoolComponent")
public class AfterSchoolComponent {

    @Id
    private Long id;

    @Column(name = "visible")
    private Boolean visible;

    @Column(name = "label")
    private String label;

    @Column(name = "title")
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "image_url_1")
    private String imageUrl1;

    public AfterSchoolComponent(Long id, Boolean visible, String label, String title, String description, String imageUrl, String imageUrl1) {
        this.id = id;
        this.visible = visible;
        this.label = label;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.imageUrl1 = imageUrl1;
    }

    public AfterSchoolComponent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }
}
