package sk.uniza.feit.security.configuration.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import sk.uniza.feit.user.domain.User;
import sk.uniza.feit.user.token.AccessToken;
import sk.uniza.feit.user.token.AccessTokenRepository;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;


@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final AccessTokenRepository accessTokenRepository;

    @Value("${application.security.jwt.secret-key}")
    private String jwtSecret;

    @Value("${application.security.jwt.expiration}")
    private int jwtExpirationMs;

    public JwtUtils(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public AccessToken generateJwtToken(Authentication authentication) {
        User userPrincipal = (User) authentication.getPrincipal();
        Date date = new Date((new Date()).getTime() + jwtExpirationMs);
        LocalDateTime expiration = LocalDateTime.now().plusSeconds(jwtExpirationMs / 1000);

        String token = Jwts.builder()
                .subject(userPrincipal.getUsername())
                .claim("email", userPrincipal.getUsername())
                .claim("roles", userPrincipal.getAuthorities())
                .claim("name", userPrincipal.getName())
                .issuedAt(new Date())
                .expiration(date)
                .signWith(getSigningKey())
                .compact();

        return sk.uniza.feit.user.token.AccessTokenFactory.create(
                token,
                expiration,
                userPrincipal.getId()
        );
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String getUserEmailFromJwtToken(String token) {
        return Jwts.parser().
                verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        return isTokenValid(authToken);
    }

    private boolean isTokenValid(String token) {
        try {
            boolean isSigned = Jwts.parser().verifyWith(getSigningKey()).build().isSigned(token);
            AccessToken accessToken = accessTokenRepository.findByToken(token);
            boolean exist = accessToken != null;
            return isSigned && exist;
        } catch (Exception e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
            return false;
        }
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public int getJwtExpirationMs() {
        return jwtExpirationMs;
    }

    public void setJwtExpirationMs(int jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }
}
