package sk.uniza.feit.site.domain.components.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "countdown_component")
public class CountdownComponent {

    @Id
    @SequenceGenerator(name = "countdown_component_id_seq", sequenceName = "countdown_component_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "countdown_component_id_seq")
    private Long id;

    @Column(name = "visible")
    public boolean visible;

    @Column(name = "end_date")
    public LocalDateTime endDate;

    @Column(name = "application_text")
    public String applicationText;

    public CountdownComponent() {
    }

    public CountdownComponent(Long id, boolean visible, LocalDateTime endDate, String applicationText) {
        this.id = id;
        this.visible = visible;
        this.endDate = endDate;
        this.applicationText = applicationText;
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

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getApplicationText() {
        return applicationText;
    }

    public void setApplicationText(String applicationText) {
        this.applicationText = applicationText;
    }
}
