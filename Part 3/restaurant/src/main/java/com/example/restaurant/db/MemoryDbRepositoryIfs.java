package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    Optional<T> findById(int idx);
    T save(T entity);
    void deleteById(int idx);
    List<T> findAll();
}
