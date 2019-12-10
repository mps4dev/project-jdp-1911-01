package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.domain.UserNotAuthenticated;
import com.kodilla.ecommercee.domain.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Random;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserMapper userMapper;

    private final static Random RANDOM_KEY = new Random();

    public UserDto get(long userId) throws UserNotFoundException {
        return userMapper.mapToUserDto(repository.findOrThrow(userId));
    }

    public User create(UserDto userDto) {
        return repository.save(userMapper.mapToUser(userDto));
    }

    public void delete(long userId) throws UserNotFoundException {
        repository.delete(repository.findOrThrow(userId));
    }

    public UserDto blockUser(long userId) throws UserNotFoundException {
        User userToBlock = repository.findOrThrow(userId);
        userToBlock.setBlocked(true);
        return userMapper.mapToUserDto(userToBlock);
    }

    public Long getUniqueKey(long userId, String userName) throws UserNotFoundException, UserNotAuthenticated {
        User userForKey = repository.findOrThrow(userId);
        if (userForKey.getName().equals(userName)) {
            return userId + RANDOM_KEY.nextLong();
        } else {
            throw new UserNotAuthenticated();
        }
    }
}