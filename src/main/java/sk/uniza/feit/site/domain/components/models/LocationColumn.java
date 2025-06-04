package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class LocationColumn {

    @Id
    @SequenceGenerator(name = "location_column_id_seq", sequenceName = "location_column_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "location_column_id_seq")
    private Long id;

    private String text;

    private String url;

    public LocationColumn() {
    }

    public LocationColumn(Long id, String text, String url) {
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
