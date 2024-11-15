package service;

import Enomerator.UserActivity;
import Enomerator.UserRole;
import Repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.UUID;


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
        User userInDb = repository.findByUsername(user.getUsername());
        return  userInDb != null && userInDb.getActive();
    }


    /** only for Super admin to get admins, and for Admin to get managers **/
    public ArrayList<User> getUsersByRole(UserRole role){
        ArrayList<User>userlist = repository.getUsersByRole(role);
        return userlist;
    }


    /**this is for manager**/
//    public ArrayList<User> getUsersByRole(UserRole role, ){
//        ArrayList
//    }
}
