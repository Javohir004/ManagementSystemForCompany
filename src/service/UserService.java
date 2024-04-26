package service;

import enomerator.UserRole;
import repository.UserRepository;
import model.User;

import java.util.ArrayList;
import java.util.UUID;

public class UserService extends BaseService<User, UserRepository>{

    public User signIn(String username, String password) {
        User user = repository.findByUsername(username , password);
        if(user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }


    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public boolean check(User user) {
        User userInDb = repository.findByUsername(user.getUsername(),user.getPassword());
        return  userInDb != null && userInDb.getActive();
    }


    /** only for Super admin to get admins, and for Admin to get managers **/
    public ArrayList<User> getUsersByRole(UserRole role){
        return repository.getUsersByRole(role);
    }




    public ArrayList<User> getBlockedUser(UserRole role){
        return repository.showBlocked(role);
    }


    public ArrayList<User> showEmployersByManager(UUID managerId){
        return repository.showEmployersByManagerId(managerId);
    }

}
