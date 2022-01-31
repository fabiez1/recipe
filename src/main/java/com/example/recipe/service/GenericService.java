package com.example.recipe.service;

import java.util.List;

public interface GenericService<T, FORM> {
    T create(FORM form);
    T findById(int id);
    List<T> findAll();
    T update(int id, FORM form);
    void delete(int id);
}
