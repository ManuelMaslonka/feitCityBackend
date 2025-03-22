package sk.uniza.feit.blog.domain;

public class AlreadyExistEntity extends RuntimeException {
    public AlreadyExistEntity(String message) {
        super(message);
    }
}
