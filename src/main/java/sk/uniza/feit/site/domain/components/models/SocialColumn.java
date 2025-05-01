package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

@Table
@Entity
public class SocialColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String url;

    private String icon;

    public SocialColumn() {
    }

    public SocialColumn(Long id, String text, String url, String icon) {
        this.id = id;
        this.text = text;
        this.url = url;
        this.icon = icon;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
