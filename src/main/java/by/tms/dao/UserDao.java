package by.tms.dao;

import by.tms.entity.User;

public interface UserDao {
    void createUser(User user);
    boolean containsByLogin(String login);
    boolean containsByLoginAndPassword(String login, String password);
}
