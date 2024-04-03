package ru.netology.authorizationservice.User;

import org.springframework.stereotype.Repository;
import ru.netology.Authorities;

import java.util.List;

@Repository
public interface UserRepository {
    List<Authorities> getUserAuthorities(String user, String password);
}
