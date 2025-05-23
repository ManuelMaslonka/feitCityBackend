package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

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

    public void addLogoItem(LogoItem logoItem) {
        this.logoItems.add(logoItem);
    }
}
