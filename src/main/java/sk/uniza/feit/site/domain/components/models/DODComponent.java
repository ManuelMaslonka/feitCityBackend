package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

@Table(name = "dod_component")
@Entity
public class DODComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "title")
    private String title;

    @Column(name = "button_text")
    private String buttonText;

    @Column(name = "button_link")
    private String buttonLink;

    public DODComponent() {}

    public DODComponent(Long id, boolean visible, String title, String buttonText, String buttonLink) {
        this.id = id;
        this.visible = visible;
        this.title = title;
        this.buttonText = buttonText;
        this.buttonLink = buttonLink;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public String getButtonLink() {
        return buttonLink;
    }

    public void setButtonLink(String buttonLink) {
        this.buttonLink = buttonLink;
    }
}
