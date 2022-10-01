package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);//возможность добавить Usera

    User getUserById(int id);//возможность получить пользователя по id

    User updateUser(User user, int id);//возможность изменить Usera

    void deleteUser(int id);//возможность удалить Usera
}
