package service;

import model.Role;
import model.User;

import java.util.List;

public interface UserDao {
    // добавление пользователя
    User add(User user);


    User getById(int id);

    //получение всех пользователей
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUser(User user);
    // добавление роли к пользователю
    void addRoleToUser(User user, Role role);
}
