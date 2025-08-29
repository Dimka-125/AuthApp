package ru.netology.AuthApp.repository;



import ru.netology.AuthApp.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {

    // Моделируем "базу данных": логин → (пароль, права)
    private final Map<String, UserCredentials> userDb = new HashMap<>();

    public UserRepository() {
        // Добавим тестовых пользователей
        userDb.put("admin", new UserCredentials("admin123", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        userDb.put("user", new UserCredentials("user123", Arrays.asList(Authorities.READ)));
        userDb.put("writer", new UserCredentials("write123", Arrays.asList(Authorities.WRITE)));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        UserCredentials credentials = userDb.get(user);
        if (credentials != null && credentials.password.equals(password)) {
            return new ArrayList<>(credentials.authorities);
        }
        return Collections.emptyList(); // если пользователь не найден или пароль не совпадает
    }

    // Вспомогательный класс для хранения данных пользователя
    private static class UserCredentials {
        String password;
        List<Authorities> authorities;

        UserCredentials(String password, List<Authorities> authorities) {
            this.password = password;
            this.authorities = authorities;
        }
    }
}