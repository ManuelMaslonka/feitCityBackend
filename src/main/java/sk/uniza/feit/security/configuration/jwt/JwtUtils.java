package sk.uniza.feit.security.configuration.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sk.uniza.feit.user.token.AccessToken;
import sk.uniza.feit.user.token.AccessTokenRepository;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.util.Date;


@Service
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final AccessTokenRepository accessTokenRepository;

    private String jwtSecret = "f45666c0d61ee85f12c95767f3c27ae4c08711387ada21ab3ba6828a133dd278";

    private int jwtExpirationMs = 8640000;

    public JwtUtils(AccessTokenRepository accessTokenRepository) {
        this.accessTokenRepository = accessTokenRepository;
    }

    public AccessToken generateJwtToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();
        Date date = new Date((new Date()).getTime() + jwtExpirationMs);
        LocalDateTime expiration = LocalDateTime.now().plusSeconds(jwtExpirationMs / 1000);

        String token = Jwts.builder()
                .subject(userPrincipal.getUsername())
                .claim("email", userPrincipal.getUsername())
                .claim("roles", userPrincipal.getAuthorities())
                .issuedAt(new Date())
                .expiration(date)
                .signWith(getSigningKey())
                .compact();

        return sk.uniza.feit.user.token.AccessTokenFactory.create(
                token,
                expiration,
                null
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
