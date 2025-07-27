package org.pronet.app.repositories;

import org.pronet.app.abstracts.BaseModel;

import java.util.List;

public interface BaseRepository<TEntity extends BaseModel> {
    void create(TEntity entity);
    TEntity getById(Long id);
    List<TEntity> getAll();
    void update(TEntity entity);
    void deleteById(Long id);
}
