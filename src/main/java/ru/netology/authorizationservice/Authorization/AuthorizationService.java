package ru.netology.authorizationservice.Authorization;


import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.netology.Authorities;
import ru.netology.authorizationservice.Credentials.InvalidCredentials;
import ru.netology.authorizationservice.User.UserRepository;
import ru.netology.errorUser.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (CollectionUtils.isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }
}
