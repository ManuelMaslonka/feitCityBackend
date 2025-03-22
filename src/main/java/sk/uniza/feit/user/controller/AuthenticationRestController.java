package sk.uniza.feit.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import sk.uniza.feit.security.configuration.LogoutService;
import sk.uniza.feit.security.domain.dto.SignInRequest;
import sk.uniza.feit.security.domain.dto.SignInResponse;
import sk.uniza.feit.security.domain.dto.SignUpRequest;
import sk.uniza.feit.security.domain.service.AuthenticationService;
import sk.uniza.feit.security.domain.service.CurrentUserDetailService;
import sk.uniza.feit.security.mapper.SignInRequestMapper;
import sk.uniza.feit.security.mapper.SignInResponseMapper;
import sk.uniza.feit.security.mapper.SignUpRequestMapper;
import sk.uniza.feit.site.rest.api.AuthenticationRestApi;
import sk.uniza.feit.site.rest.dto.SignInRequestDto;
import sk.uniza.feit.site.rest.dto.SignInResponseDto;
import sk.uniza.feit.site.rest.dto.SignUpRequestDto;
import sk.uniza.feit.user.domain.SettingsService;

@RestController
public class AuthenticationRestController implements AuthenticationRestApi {


    private final SignUpRequestMapper signUpRequestMapper;
    private final SignInRequestMapper signInRequestMapper;
    private final SignInResponseMapper signInResponseMapper;
    private final AuthenticationService authenticationService;
    private final CurrentUserDetailService currentUserDetailService;
    private final LogoutService logoutService;
    private final SettingsService settingsService;


    public AuthenticationRestController(
            SignUpRequestMapper signUpRequestMapper,
            SignInRequestMapper signInRequestMapper,
            SignInResponseMapper signInResponseMapper,
            AuthenticationService authenticationService,
            CurrentUserDetailService currentUserDetailService,
            LogoutService logoutService,
            SettingsService settingsService
    ) {
        this.signUpRequestMapper = signUpRequestMapper;
        this.signInRequestMapper = signInRequestMapper;
        this.signInResponseMapper = signInResponseMapper;
        this.authenticationService = authenticationService;
        this.currentUserDetailService = currentUserDetailService;
        this.logoutService = logoutService;
        this.settingsService = settingsService;
    }

    @Override
    public ResponseEntity<Void> logout() {
        Long userId = currentUserDetailService.getUserId();
        logoutService.logout(userId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SignInResponseDto> signin(SignInRequestDto signInRequestDto) {
        if (!settingsService.getEnabledLogin()) {
            return ResponseEntity.notFound().build();
        }

        SignInRequest signInRequest = signInRequestMapper.toEntity(signInRequestDto);
        SignInResponse signInResponse = authenticationService.signInUser(signInRequest);
        return ResponseEntity.ok(signInResponseMapper.toDto(signInResponse));
    }

    @Override
    public ResponseEntity<Void> signup(SignUpRequestDto signUpRequestDto) {
        if (!settingsService.getEnabledRegistration()) {
            return ResponseEntity.notFound().build();
        }

        SignUpRequest signUpRequest = signUpRequestMapper.toEntity(signUpRequestDto);
        authenticationService.signUpUser(signUpRequest);
        return ResponseEntity.ok().build();
    }

}
