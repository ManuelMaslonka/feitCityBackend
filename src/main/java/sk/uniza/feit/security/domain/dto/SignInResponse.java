package sk.uniza.feit.security.domain.dto;


import sk.uniza.feit.user.token.AccessToken;

public record SignInResponse (
        AccessToken accessToken
) {
}
