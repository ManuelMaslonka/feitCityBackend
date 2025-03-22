package sk.uniza.feit.user.domain;

import jakarta.persistence.*;

@Table
@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean enabledRegistration;

    private boolean enabledLogin;

    public Settings() {
    }

    public Settings(Long id, boolean enabledRegistration, boolean enabledLogin) {
        this.id = id;
        this.enabledRegistration = enabledRegistration;
        this.enabledLogin = enabledLogin;
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

    public boolean isEnabledLogin() {
        return enabledLogin;
    }

    public void setEnabledLogin(boolean enabledLogin) {
        this.enabledLogin = enabledLogin;
    }
}
