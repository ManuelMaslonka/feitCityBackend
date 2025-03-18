package sk.uniza.feit.security.configuration;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import sk.uniza.feit.user.token.AccessToken;
import sk.uniza.feit.user.token.AccessTokenRepository;

@Service
public class LogoutService {

    private final AccessTokenRepository tokenRepository;

    public LogoutService(AccessTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public void logout(Long userId) {
        AccessToken storedToken = tokenRepository.findAccessTokenByUserId(userId);
        tokenRepository.delete(storedToken);
        SecurityContextHolder.clearContext();
    }

}

