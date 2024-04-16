package service;

import Repository.UserRepository;
import model.User;

public class UserService extends BaseService<User, UserRepository>{


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
