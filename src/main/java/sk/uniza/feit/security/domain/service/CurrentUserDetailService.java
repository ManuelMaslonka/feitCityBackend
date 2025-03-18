package sk.uniza.feit.security.domain.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sk.uniza.feit.user.domain.User;
import sk.uniza.feit.user.domain.UserService;

@Service
public class CurrentUserDetailService {

    private final UserService userFacade;

    public CurrentUserDetailService(UserService userFacade) {
        this.userFacade = userFacade;
    }

    public UserDetails getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            if (!((UserDetails) principal).isEnabled()) {
                throw new RuntimeException("User is not enabled");
            }
            return (UserDetails) principal;
        }
        throw new RuntimeException("User is not authenticated");
    }

    public Long getUserId() {
        return getFullCurrentUser().getId();
    }

    public String getUserEmail() {
        return getCurrentUser().getUsername();
    }

    public User getFullCurrentUser() {
        return userFacade.read(getUserEmail());
    }
}
