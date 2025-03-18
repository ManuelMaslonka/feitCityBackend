package sk.uniza.feit.user.domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    public User read(long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User not found")
        );
    }

    public User read(String email) {
        return userRepository.findByEmail(email);
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> readAll() {
        return userRepository.findAll();
    }

    public void update(Long id, User user) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        User updatedUser = UserFactory.updateUser(oldUser, user);
        userRepository.save(updatedUser);
    }

    public boolean existByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}

