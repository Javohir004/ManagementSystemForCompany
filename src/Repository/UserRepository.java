package Repository;

import Enomerator.UserRole;
import model.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class UserRepository extends BaseRepository <User> {


    public Optional<User> findById(UUID id) {
        if (id.getLeastSignificantBits() % 2 == 0) {
            return Optional.of(new User());
        }
        return Optional.empty();
    }

    public User findByUsername(String username) {
        for (User user : data) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public ArrayList<User> getUsersByRole(UserRole role){
        ArrayList<User>userrole = new ArrayList<>();
        for (User datum : data) {
            if(datum.getRole().equals(role) && datum.isActive()){
                userrole.add(datum);
            }
        }
        return userrole;
    }



}
