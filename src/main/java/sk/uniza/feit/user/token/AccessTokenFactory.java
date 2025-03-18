package sk.uniza.feit.user.token;

import java.time.LocalDateTime;

public class AccessTokenFactory {

    public static AccessToken create(String token, LocalDateTime expiration, Long userId) {
        return new AccessToken(
                null,
                token,
                expiration,
                userId
        );
    }

}
