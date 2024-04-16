package service;

import Repository.BaseRepository;
import model.BaseModel;

import java.util.Optional;
import java.util.UUID;

public abstract class BaseService <T extends BaseModel, R extends BaseRepository<T>>{

    protected final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public int add(T t) {
        if (check(t)) {
            return -1;
        }
        repository.add(t);
        return 1;
    }

    public Optional<T> findById(UUID id) {
        return repository.findById(id);
    }

    public abstract T mapNullFields(T original, T update);

    public abstract boolean check(T t);


}
