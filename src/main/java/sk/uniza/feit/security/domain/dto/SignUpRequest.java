package sk.uniza.feit.security.domain.dto;


public record SignUpRequest (
        String name,
        String email,
        String password
) {
}
