package sk.uniza.feit.user.token;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {


    AccessToken findByToken(String token);

    AccessToken findAccessTokenByUserId(Long userId);

    List<AccessToken> findAllByUserId(Long userId);

}
