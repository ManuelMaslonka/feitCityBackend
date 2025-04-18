package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class MenuItem {

    @Id
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "url")
    private String url;

    public MenuItem() {
    }

    public MenuItem(Long id, String text, String url) {
        this.id = id;
        this.text = text;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
