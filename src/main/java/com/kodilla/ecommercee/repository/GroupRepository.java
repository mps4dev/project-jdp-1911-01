package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface GroupRepository extends CrudRepository<Group, Long> {

    @Override
    List<Group> findAll();

    Optional<Group> findById(long id);

    @Override
    Group save(Group group);
}
