package ru.netology.authorizationservice.User;

import ru.netology.Authorities;

import java.util.Collections;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public List<Authorities> getUserAuthorities(String user, String password) {
        // Реализуйте этот метод для получения разрешений пользователя из базы данных или другого источника данных
        // Возвращайте список разрешений пользователя или пустой список, если пользователь не найден
        return Collections.emptyList();
    }
}
