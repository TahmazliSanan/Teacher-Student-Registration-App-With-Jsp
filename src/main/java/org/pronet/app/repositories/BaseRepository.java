package org.pronet.app.repositories;

import java.util.List;

public interface BaseRepository<TEntity> {
    void create(TEntity entity);
    TEntity getById(Long id);
    List<TEntity> getAll();
    void update(TEntity entity);
    void deleteById(Long id);
}
