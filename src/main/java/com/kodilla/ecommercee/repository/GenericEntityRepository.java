package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.GenericEntity;
import com.kodilla.ecommercee.domain.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericEntityRepository<T> extends CrudRepository<T, Long> {

    @Override
    List<T> findAll();

    Optional<T> findById(long id);

    GenericEntity save();

    void delete();

    default T findOrThrow(long id) throws EntityNotFoundException {
        T tObject = findById(id).orElseThrow(() -> new EntityNotFoundException("Entity with id: " + id + " - not found"));
        return tObject;
    }
}
