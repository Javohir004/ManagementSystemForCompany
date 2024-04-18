package Repository;

import Enomerator.UserRole;
import model.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public class UserRepository extends BaseRepository<User> {


    public Optional<User> findById(UUID id) {

        for (User datum : data) {
            if (datum.getId().equals(id) && datum.isActive()) {
                return Optional.of(datum);
            }
        }
        return Optional.empty();
    }

    public User findByUsername(String username) {
        for (User user : data) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }


    public ArrayList<User> getUsersByRole(UserRole role) {
        ArrayList<User> userrole = new ArrayList<>();
        for (User datum : data) {
            if (datum.getRole().equals(role) && datum.isActive()) {
                userrole.add(datum);
            }
        }
        return userrole;
    }

    public ArrayList<User> showBlocked(UserRole role){
        ArrayList<User> userrole = new ArrayList<>();
        for (User datum : data) {
            if (datum.getRole().equals(role) && !datum.isActive()) {
                userrole.add(datum);
            }
        }
        return userrole;
    }

}
