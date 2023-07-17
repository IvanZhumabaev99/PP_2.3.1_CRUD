package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);// добавить Usera

    User getUserById(int id);// получить пользователя по id

    User updateUser(User user, int id);// изменить Usera

    void deleteUser(int id);// удалить Usera
}
