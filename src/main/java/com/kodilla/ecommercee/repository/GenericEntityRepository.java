package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericEntityRepository<T> extends JpaRepository<T, Long> {
    @Override
    List<T> findAll();

    Optional<T> findById(long id);

    <S extends T> S save(S entity);

    void delete(T entity);

    default T findOrThrow(long id) throws EntityNotFoundException {
        T tObject = findById(id).orElseThrow(() -> new EntityNotFoundException("Entity with id: " + id + " - not found"));
        return tObject;
    }
}
