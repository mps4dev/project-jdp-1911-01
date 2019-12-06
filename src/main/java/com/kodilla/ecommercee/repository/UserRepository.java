package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User save(User user);

    Optional<User> findById(long id);

    @Override
    void delete(User user);

    default User findOrThrow(long id) throws UserNotFoundException {
        User user = findById(id).orElseThrow(UserNotFoundException::new);
        return user;
    }
}