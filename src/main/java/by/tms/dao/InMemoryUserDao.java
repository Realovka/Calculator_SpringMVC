package by.tms.dao;

import by.tms.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class InMemoryUserDao implements UserDao{
    private List<User> users = new ArrayList<>();

    {
        users.add(new User("Admin","Admin","Admin"));
        users.add(new User("User","User","User"));
    }


    public List<User> getUsers() {
        return users;
    }

    @Override
    public void createUser(User user) {
       users.add(user);
    }

    @Override
    public boolean containsByLogin(String login) {
        for (User item: users){
            if (item.getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsByLoginAndPassword(String login, String password) {
        for (User item: users){
            if(item.getLogin().equals(login) && item.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
