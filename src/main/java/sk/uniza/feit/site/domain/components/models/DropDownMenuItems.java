package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DropDownMenuItems {

    @Id
    private Long id;

    private String url;

    private String text;

    public DropDownMenuItems() {}

    public DropDownMenuItems(Long id, String url, String text) {
        this.id = id;
        this.url = url;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
