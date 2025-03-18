package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;
import jdk.jfr.Name;

import java.util.List;

@Table
@Entity
public class LogoComponent {

    @Id
    @SequenceGenerator(
            name = "logo_component_sequence",
            sequenceName = "logo_component_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logo_component_sequence"
    )
    private Long id;

    @Column(name = "visible")
    private boolean visible;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "logo_component_id")
    private List<LogoItem> logoItems;

    public LogoComponent() {}

    public LogoComponent(Long id, boolean visible, List<LogoItem> logoItems) {
        this.id = id;
        this.visible = visible;
        this.logoItems = logoItems;
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

    public List<LogoItem> getLogoItems() {
        return logoItems;
    }

    public void setLogoItems(List<LogoItem> logoItems) {
        this.logoItems = logoItems;
    }
}
