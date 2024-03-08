package com.javarush.movie.dao;

import java.util.List;
import java.util.Optional;

public interface CrudDao<E, ID> {

    Optional<E> findById(ID id);

    List<E> findAll();

    // overload with pagination

    <S extends E> S save(E entity);

    boolean deleteById(ID id);
}
