package by.tms.service;

import by.tms.dao.InMemoryUserDao;
import by.tms.entity.User;
import by.tms.service.exception.DuplicateUserException;
import by.tms.service.exception.InvalidUserException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private InMemoryUserDao inMemoryUserDao;

    public UserService(InMemoryUserDao inMemoryUserDao) {
        this.inMemoryUserDao = inMemoryUserDao;
    }

    public InMemoryUserDao getInMemoryUserDao() {
        return inMemoryUserDao;
    }

    public void createUser(User user){
        if(inMemoryUserDao.containsByLogin(user.getLogin())){
            throw new DuplicateUserException("Such user is already");
        }
        inMemoryUserDao.createUser(user);
    }

    public boolean validateUser(User user){
        if (inMemoryUserDao.containsByLoginAndPassword(user.getLogin(),user.getPassword())){
            throw new InvalidUserException("No such user");
        }
        return true;
    }
}
