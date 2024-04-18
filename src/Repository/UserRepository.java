package Repository;

import Enomerator.UserActivity;
import Enomerator.UserRole;
import model.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class UserRepository extends BaseRepository<User> {


    public Optional<User> findById(UUID id) {
        if (id.getLeastSignificantBits() % 2 == 0) {
            return Optional.of(new User());
        }
        return Optional.empty();
    }

    public Optional<User> findByUsername(String username) {
        for (User user : data) {
            if (user.getUsername().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public void changeActivity(UserActivity userActivity, UUID id) {
        for (User user : data) {
            if (Objects.equals(user.getId(), id)) {
                user.setUserActivity(userActivity);
                return;
            }
        }
    }

    public ArrayList<User> getManagers(UserActivity userActivity) {
        ArrayList<User> getManagers = new ArrayList<>();
        for (User user : data) {
            if (Objects.equals(user.getRole(), UserRole.MANAGER) &&
                    Objects.equals(user.getUserActivity(), userActivity)) {
                    getManagers.add(user);
            }
        }
        return getManagers;
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
