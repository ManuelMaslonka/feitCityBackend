package sk.uniza.feit.handler;

public record ErrorMessage(
        String message,
        int status,
        long timestamp
) {
}
