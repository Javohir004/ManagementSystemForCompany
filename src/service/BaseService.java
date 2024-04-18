package service;

import Enomerator.DataNotFoundException;
import Repository.BaseRepository;
import model.BaseModel;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

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

    public void delete(UUID id){
        repository.delete(id);
    }


    public int update(UUID id ,T t){
        repository.update(id , t);
        return 1;
    }

    public T findById(UUID id) {
        return repository.findById(id).orElseThrow(new Supplier<DataNotFoundException>() {
            @Override
            public DataNotFoundException get() {
                return new DataNotFoundException("data not found");
            }
        });
    }

    public abstract boolean check(T t);


}
