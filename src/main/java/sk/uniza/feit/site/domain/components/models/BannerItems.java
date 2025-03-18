package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class BannerItems {

    @Id
    private Long id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "label")
    private String label;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;

    @Column(name = "name_of_action")
    private String nameOfAction;

    @Column(name = "icon")
    private String icon;

    public BannerItems() {
    }

    public BannerItems(Long id, String imageUrl, boolean visible, String label, String title, String description, String link, String nameOfAction,
                       String icon) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.visible = visible;
        this.label = label;
        this.title = title;
        this.description = description;
        this.link = link;
        this.nameOfAction = nameOfAction;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNameOfAction() {
        return nameOfAction;
    }

    public void setNameOfAction(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }
}
