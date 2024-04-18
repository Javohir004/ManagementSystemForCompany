package Repository;
import model.BaseModel;

import model.User;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

public abstract class BaseRepository<T extends BaseModel> {
    protected final ArrayList<T> data = new ArrayList<>();

    public ArrayList<T> getAll(Boolean state) {
        ArrayList<T> data2 = new ArrayList<>();
        for (T t : data) {
            if (t.getActive() == state) {
                data2.add(t);
            }
        }
        return data2;
    }

    public void add(T t) {
        data.add(t);
    }

    public void delete(UUID id) {
        for (T t : data) {
            if (t.getId().equals(id)) {
                data.remove(t);
                return;
            }
        }
    }

    public Optional<T> findById(UUID id) {
        for (T t : data) {
            if (t.getId().equals(id)) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public void update(UUID id, T update) {
        int i = 0;
        for (T t : data) {
            if (t.getId().equals(id)) {
                update.setId(id);
                data.set(i, update);
            }
            i++;
        }
    }

}
