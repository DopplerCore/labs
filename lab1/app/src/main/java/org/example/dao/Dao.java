package org.example.dao;

import java.util.List;

public interface Dao<idType, entityType> {
    
    public entityType getById(idType id);
    
    List<entityType> getAll();
    
    void save(entityType entity);
    
    void update(idType id,entityType entity);
    
    void delete(idType id);
}
