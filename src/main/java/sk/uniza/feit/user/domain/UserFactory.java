package sk.uniza.feit.user.domain;

import org.springframework.stereotype.Component;
import sk.uniza.feit.blog.domain.AlreadyExistEntity;
import sk.uniza.feit.security.domain.dto.SignUpRequest;
import sk.uniza.feit.user.exception.EmailAlreadyExistException;

@Component
public class UserFactory {

    private final UserRepository userRepository;

    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static User updateUser(User oldUser, User user) {

        return new User(
                oldUser.getId(),
                user.getName() != null ? user.getName() : oldUser.getName(),
                user.getEmail() != null ? user.getEmail() : oldUser.getEmail(),
                user.getRole() != null ? user.getRole() : oldUser.getRole(),
                user.getPassword() != null ? user.getPassword() : oldUser.getPassword()
        );

    }

    public User create(SignUpRequest signUpRequest, String password) {
        boolean exist = userRepository.existsByEmail(signUpRequest.email());
        boolean userNameAlreadyExist = userRepository.existsByName(signUpRequest.name());

        if (exist) {
            throw new EmailAlreadyExistException("Email sa už používa.");
        }

        if (userNameAlreadyExist) {
            throw new AlreadyExistEntity("Používateľské meno sa už používa.");
        }

        User user = new User(signUpRequest.name(), signUpRequest.email(), Role.ROLE_ADMIN, password);
        return userRepository.save(user);
    }
}
