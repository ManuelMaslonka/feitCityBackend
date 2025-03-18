package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class LogoItem {

    @Id
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "alt")
    private String alt;

    public LogoItem() {}

    public LogoItem(Long id, String imageUrl, String alt) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.alt = alt;
    }

    public String isAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
