package repositories.interfaces.base;

import entities.base.BaseEntity;

import java.util.List;

public interface BaseRepository<T extends BaseEntity<Integer>> {
    T ins(T t);

    T readById(Integer id);

    List<T> readAll();

    T update(T t);

    void delete(T t);

    void truncate(String tableName);
}
