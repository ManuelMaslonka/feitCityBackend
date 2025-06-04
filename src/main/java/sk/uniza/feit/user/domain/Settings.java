package sk.uniza.feit.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean enabledRegistration;

    public Settings() {
    }

    public Settings(Long id, boolean enabledRegistration) {
        this.id = id;
        this.enabledRegistration = enabledRegistration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEnabledRegistration() {
        return enabledRegistration;
    }

    public void setEnabledRegistration(boolean enabledRegistration) {
        this.enabledRegistration = enabledRegistration;
    }

}
