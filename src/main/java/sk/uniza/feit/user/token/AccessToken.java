package sk.uniza.feit.user.token;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity
public class AccessToken {

    @Id
    @SequenceGenerator(name = "access_token_id_seq", sequenceName = "access_token_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "access_token_id_seq")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "expiration")
    private LocalDateTime expiration;

    @Column(name = "user_id")
    private Long userId;

    public AccessToken() {
    }

    public AccessToken(Long id, String token, LocalDateTime expiration, Long userId) {
        this.id = id;
        this.token = token;
        this.expiration = expiration;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDateTime expiration) {
        this.expiration = expiration;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
