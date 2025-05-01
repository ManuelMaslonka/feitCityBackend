package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

@Entity
@Table
public class ContactColumn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private String url;

    public ContactColumn() {
    }

    public ContactColumn(Long id, String text, String url) {
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
