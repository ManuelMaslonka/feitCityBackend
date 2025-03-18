package sk.uniza.feit.security.domain.dto;

public record SignInRequest (
        String email,
        String password
) {
}
