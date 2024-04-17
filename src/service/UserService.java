package service;

import Repository.UserRepository;
import model.User;

public class UserService extends BaseService<User, UserRepository>{

    public User signIn(String username, String password) {
        User user = repository.findByUsername(username);
        if(user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public User mapNullFields(User original, User update) {
        return null;
    }

    @Override
    public boolean check(User user) {
        return false;
    }
}
