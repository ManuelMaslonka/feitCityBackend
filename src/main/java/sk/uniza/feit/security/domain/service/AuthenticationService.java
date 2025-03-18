package sk.uniza.feit.security.domain.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sk.uniza.feit.security.configuration.jwt.JwtUtils;
import sk.uniza.feit.security.domain.dto.SignInRequest;
import sk.uniza.feit.security.domain.dto.SignInResponse;
import sk.uniza.feit.security.domain.dto.SignUpRequest;
import sk.uniza.feit.user.domain.UserFactory;
import sk.uniza.feit.user.domain.UserService;
import sk.uniza.feit.user.token.AccessToken;
import sk.uniza.feit.user.token.AccessTokenRepository;

import java.util.logging.Logger;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserFactory userFactory;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AccessTokenRepository accessTokenRepository;

    public AuthenticationService(
            UserService userService,
            PasswordEncoder passwordEncoder,
            UserFactory userFactory,
            AuthenticationManager authenticationManager,
            JwtUtils jwtUtils,
            AccessTokenRepository accessTokenRepository
    ) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.userFactory = userFactory;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.accessTokenRepository = accessTokenRepository;
    }

    public void signUpUser(SignUpRequest signUpRequest) {
        String password = passwordEncoder.encode(signUpRequest.password());
        userFactory.create(signUpRequest, password);
    }

    public SignInResponse signInUser(SignInRequest signInRequest) {
        Logger.getGlobal().info("Sign in request: " + signInRequest);
        Logger.getGlobal().info(new UsernamePasswordAuthenticationToken(signInRequest.email(), signInRequest.password()).toString());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.email(), signInRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        AccessToken token = jwtUtils.generateJwtToken(authentication);

        cancelAllAccessTokens(signInRequest);
        saveAccessToken(token);

        return new SignInResponse(
                token
        );
    }

    private void cancelAllAccessTokens(SignInRequest signInRequest) {
        Long userId = userService.read(signInRequest.email()).getId();
        accessTokenRepository.deleteAll(accessTokenRepository.findAllByUserId(userId));
    }

    public AccessToken saveAccessToken(AccessToken accessToken) {
        return accessTokenRepository.save(accessToken);
    }

    public AccessToken findAccessTokenByToken(String token) {
        return accessTokenRepository.findByToken(token);
    }

    public void deleteAccessToken(AccessToken accessToken) {
        accessTokenRepository.delete(accessToken);
    }
}
