package services.impls.base;

import entities.base.BaseEntity;
import lombok.RequiredArgsConstructor;
import repositories.interfaces.base.BaseRepository;
import services.interfaces.base.BaseService;

import java.util.List;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity<Integer>
        , R extends BaseRepository<T>>
        implements BaseService<T> {
    protected final R repository;

    @Override
    public T insert(T t) {
        return repository.ins(t);
    }

    @Override
    public T findById(Integer id) {
        return repository.readById(id);
    }

    @Override
    public List<T> findAll() {
        return repository.readAll();
    }

    @Override
    public T update(T t) {
        return repository.update(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void truncate(String tableName) {
        repository.truncate(tableName);
    }
}
