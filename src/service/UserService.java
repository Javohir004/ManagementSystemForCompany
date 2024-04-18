package service;

import Enomerator.UserActivity;
import Repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserService extends BaseService<User, UserRepository>{


    public UserService(UserRepository repository) {
        super(repository);
    }

    public ArrayList<User> getManagers(UserActivity userActivity){
        return repository.getManagers(userActivity);
    }

    @Override
    public User mapNullFields(User original, User update) {
        return null;
    }
    public void changeActivity(UserActivity userActivity,UUID id){
        repository.changeActivity(userActivity,id);
    }


    @Override
    public boolean check(User user) {
        return false;
    }
}
