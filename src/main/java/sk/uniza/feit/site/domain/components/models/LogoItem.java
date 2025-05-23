package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table
@Entity(name = "logo_item")
public class LogoItem {

    @Id
    @SequenceGenerator(
            name = "logo_item_sequence",
            sequenceName = "logo_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logo_item_sequence"
    )
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "alt")
    private String alt;

    public LogoItem() {
    }

    public LogoItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

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
