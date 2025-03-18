package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "slider_component")
public class SliderComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "title")
    private String title;

    @Column(name = "label")
    private String label;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "slider_component_id")
    private List<SliderItem> items;

    public SliderComponent() {}

    public SliderComponent(Long id, boolean visible, String title, String label, String description, List<SliderItem> items) {
        this.id = id;
        this.visible = visible;
        this.title = title;
        this.label = label;
        this.description = description;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public List<SliderItem> getItems() {
        return items;
    }

    public void setItems(List<SliderItem> items) {
        this.items = items;
    }
}
